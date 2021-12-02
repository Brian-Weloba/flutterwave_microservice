package com.mctv.flutterwave.controllers;

import com.mctv.flutterwave.feignclient.ApiService;
import com.mctv.flutterwave.feignclient.ApiServiceProxy;
import com.mctv.flutterwave.models.Content;
import com.mctv.flutterwave.models.Customer;
import com.mctv.flutterwave.models.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author brianweloba
 * @author hamisiandale
 * <p>
 * 1. This class is the controller for the API.
 * 2. It is responsible for handling all the requests from the front end.
 * 3. It is also responsible for handling all the requests from the backend.
 */
@RestController
@RequestMapping("/data")
@EnableFeignClients(basePackageClasses = ApiServiceProxy.class)
public class ApiController implements ApiService {
    private final ApiServiceProxy apiServiceProxy;
    private final FlutterwaveController fwController;


    /**
     * @param apiServiceProxy The api service proxy used to fetch the user's details
     * @param fwController    The flutterwave controller used to fetch the payment details
     */
    public ApiController(ApiServiceProxy apiServiceProxy, FlutterwaveController fwController) {
        this.apiServiceProxy = apiServiceProxy;
        this.fwController = fwController;
    }

    /**
     * @param email           The user's email address used to fetch the user's details
     * @param ref             The content's reference used to fetch the content's details
     * @param transactionType The transaction type used to fetch the payment details
     * @return The rave model payment view for the flutterwave payment
     * <p>
     * This method is responsible for handling fetching the payment and user details from the backend.
     */
    @GetMapping(path = "/pay")
    public ModelAndView getPaymentDetails(@RequestParam String email, @RequestParam String ref, @RequestParam(required = false) String transactionType) {
        // Get the user details and the content details from the backend
        Content content = getContentByRef(ref);
        User user = getUsersByEmail(email);
        // Create the customer object
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPhone_number(user.getPhone());
        customer.setName(user.getFullname());
        return fwController.payment(content, customer, transactionType);
    }

    /**
     * @param contentRef The content reference used to fetch the content details
     * @return           A content object containing the content details
     * @see              Content
     */
    @Override
    @GetMapping(path = "/content")
    public Content getContentByRef(@RequestParam("ref") String contentRef) {
        return apiServiceProxy.getContentByRef(contentRef);
    }

    /**
     * @param email The user's email address used to fetch the user's details
     * @return      A user object containing the user details
     * @see         User
     */
    @Override
    @GetMapping("/users")
    public User getUsersByEmail(@RequestParam String email) {
        return apiServiceProxy.getUsersByEmail(email);
    }

}
