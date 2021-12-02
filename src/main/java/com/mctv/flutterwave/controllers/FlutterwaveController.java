package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.FlutterwaveService;
import com.mctv.flutterwave.feignclient.FlutterwaveServiceProxy;
import com.mctv.flutterwave.models.*;
import com.mctv.flutterwave.repositories.FlutterwaveResponseRepository;
import com.mctv.flutterwave.repositories.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

import static com.mctv.flutterwave.utils.URLs.MICROSERVICE_URL;

/**
 * @author brianweloba
 * @author Hamisi Andale
 * <p>
 * Controller for the Flutterwave payment microservice.Used to handle the payment flow.
 */
@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = FlutterwaveServiceProxy.class)
public class FlutterwaveController implements FlutterwaveService {
    private final FlutterwaveServiceProxy proxy;
    private final PayloadRepository repo;
    private final FlutterwaveResponseRepository fwRepo;
    //    private final String url = "https://8592-105-160-95-170.ngrok.io";


    /**
     * @param proxy  FlutterwaveServiceProxy instance
     * @param repo   PayloadRepository instance
     * @param fwRepo FlutterwaveResponseRepository instance
     *               <p>
     *               This constructor is used to inject the dependencies
     */
    @Autowired
    public FlutterwaveController(FlutterwaveServiceProxy proxy, PayloadRepository repo, FlutterwaveResponseRepository fwRepo) {
        this.proxy = proxy;
        this.repo = repo;
        this.fwRepo = fwRepo;
    }

    /**
     * @param content         Content object
     * @param customer        Customer object
     * @param transactionType String transaction type
     * @return A view to the rave payment page
     * <p>
     * This method is used to initiate the payment process by redirecting the user to the rave payment page
     */
    @GetMapping("/payment")
    public ModelAndView payment(Content content, Customer customer, String transactionType) {
        Payload payload = getPayload(content, customer, transactionType);
        repo.save(payload);
        Response paymentObj = proxy.createPayment(payload);
        return new ModelAndView("redirect:" + paymentObj.getData().getLink());
    }

    /**
     * @param status         The status of the payment
     * @param tx_ref         The transaction reference of the payment
     * @param transaction_id The transaction id of the payment
     * @return On successful payment, the user is redirected to the payment success page or, on failed payment, the user is redirected to the error page
     * <p>
     * This method is used to handle the callback to the payment microservice
     */
    @GetMapping(path = "/callback")
    public ModelAndView paymentCallback(@RequestParam String status, @RequestParam String tx_ref, @RequestParam(required = false) String transaction_id) {
        // get transaction details from database
        System.out.println("ref: " + tx_ref);
//        Payload payload = repo.findByRef(tx_ref);
//        payload.setRedirect_url(MICROSERVICE_URL + "/flutterwave/callback/");
        // save to database
        saveResponse(status, tx_ref, transaction_id);
        if (status.equals("successful")) {
//            return new ModelAndView("redirect:https://mymovies.africa/view/" + payload.getMeta().getContentRef()
            return new ModelAndView("redirect:" + MICROSERVICE_URL + "/flutterwave/confirmation/" + transaction_id);
        } else {
            /* handle transaction errors */
            String message;
            switch (status) {
                case "cancelled":
                    message = "Transaction cancelled";
                    break;
                case "declined":
                    message = "Transaction declined by issuer";
                    break;
                case "timed_out":
                    message = "Transaction timed out";
                    break;
                case "insufficient_funds":
                    message = "Transaction declined due to insufficient funds";
                    break;
                case "aborted":
                    message = "Transaction aborted";
                    break;
                case "exceeded_retry_limit":
                    message = "Transaction exceeded retry limit";
                    break;
                case "declined_avs":
                    message = "Transaction declined due to address verification";
                    break;
                case "declined_csc":
                    message = "Transaction declined due to card security code";
                    break;
                case "declined_avs_csc":
                    message = "Transaction declined due to address verification and card security code";
                    break;
                case "authentication_not_available":
                    message = "Authentication is not currently available";
                    break;
                default:
                    message = "Transaction could not be processed";
                    break;
            }
            return new ModelAndView("redirect:" + MICROSERVICE_URL + "/error?status=" + status + "&message=" + message + "&tx_ref=" + tx_ref);
        }
    }

    /**
     * @param status         The status of the payment
     * @param tx_ref         The transaction reference of the payment
     * @param transaction_id The transaction id of the payment
     *                       <p>
     *                       This method is used to save the response from the payment
     */
    private void saveResponse(@RequestParam String status, @RequestParam String tx_ref, @RequestParam String transaction_id) {
        FlutterwaveResponse response = new FlutterwaveResponse();
        response.setStatus(status);
        response.setTx_ref(tx_ref);
        response.setTransaction_id(transaction_id);
        fwRepo.save(response);
    }


    /**
     * @param payload The payload of the payment
     * @return The response from flutterwave payment api.
     * <p>
     * This method is used to initilaize a payment on flutterwave.
     */
    @Override
    public Response createPayment(Payload payload) {
        return proxy.createPayment(payload);
    }

    /**
     * @param content         An instance of the content class
     * @param customer        An instance of the customer class
     * @param transactionType The type of transaction
     * @return A payload object used to pass payment details to flutterwave
     * <p>
     * This method is used to create the payload object
     */
    private Payload getPayload(Content content, Customer customer, String transactionType) {
        Payload payload = new Payload();
        //todo:if est or rental or pvod
        if (content.getIsDiscountActive().equals("1")) {
            if (!Objects.equals(content.getDiscountedPrice(transactionType), "0")) {
                payload.setAmount(content.getDiscountedPrice(transactionType));
            }

        } else {
            if ("est".equals(transactionType)) {
                payload.setAmount(content.getEst_price());
            } else if ("rental".equals(transactionType)) {
                payload.setAmount(content.getRental_price());
            } else if ("pvod".equals(transactionType)) {
                payload.setAmount(content.getPvod_price());
            }
        }
//        String amount = content.getEst_price();
//        payload.setAmount(amount);
        payload.setPayment_options("card");
        payload.setCustomer(customer);
        //todo:work on geotagging to get currency
//        payload.setCurrency(content.getCurrency());
        payload.setCurrency("KES");
        Meta meta = new Meta();
        meta.setContentRef(content.getRef());
        payload.setMeta(meta);
        payload.setRedirect_url(MICROSERVICE_URL + "/flutterwave/callback/");
        return payload;
    }

}
