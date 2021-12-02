package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.ConfirmationService;
import com.mctv.flutterwave.feignclient.ConfirmationServiceProxy;
import com.mctv.flutterwave.models.Payload;
import com.mctv.flutterwave.repositories.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.mctv.flutterwave.utils.URLs.MICROSERVICE_URL;


/**
 * @author brianweloba
 * @author hamisiandlae
 * <p>
 * This class is the controller for the confirmation page.
 */
@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = ConfirmationServiceProxy.class)
public class ConfirmationController implements ConfirmationService {

    private final ConfirmationServiceProxy proxy;
    private final PayloadRepository repo;

    @Autowired
    public ConfirmationController(ConfirmationServiceProxy proxy, PayloadRepository repo) {
        this.proxy = proxy;
        this.repo = repo;
    }

    /**
     * @param txId The transaction id of the transaction to be retrieved.
     * @return A ModelAndView object containing the confirmation page.
     * <p>
     * This method retrieves the transaction id from the database and passes it to the flutterwave confirmation service.
     * On successful retrieval of the transaction, the confirmation page is returned.
     * On unsuccessful retrieval of the transaction, the error page is returned.
     */
    @GetMapping(path = "/confirmation/{id}",
            produces = {"application/json", "text/html"})
    public ModelAndView confirm(@PathVariable("id") String txId) {

        //confirm transaction before updating backend
        Map<String, Object> response = verify(txId);
        String status = response.get("status").toString();
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        String tx_ref = data.get("tx_ref").toString();
        String message = response.get("message").toString();
        if (response.get("status").equals("success")) {
            //todo:update backend

            Payload payload = repo.findByRef(tx_ref);
            return new ModelAndView("redirect:https://mymovies.africa/view/" + payload.getMeta().getContentRef());
        } else {
            //todo:wait and try again
            return new ModelAndView("redirect:" + MICROSERVICE_URL + "/error?status=" + status + "&message=" + message + "&tx_ref=" + tx_ref);

        }
    }

    /**
     * @param id The transaction id of the transaction to be retrieved.
     * @return A Map object containing the response from the flutterwave confirmation service.
     * <p>
     * This method retrieves the transaction id from the database and passes it to the flutterwave confirmation service.
     */
    @Override
    public Map<String, Object> verify(String id) {
        return proxy.verify(id);
    }
}
