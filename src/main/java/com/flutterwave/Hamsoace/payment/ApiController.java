package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.backend.ApiService;
import com.flutterwave.Hamsoace.backend.ApiServiceProxy;
import com.flutterwave.Hamsoace.models.Content;
import com.flutterwave.Hamsoace.models.Customer;
import com.flutterwave.Hamsoace.models.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author brianweloba
 * @quthor hamisiandale
 *
 * 1. This class is the controller for the API.
 * 2. It is responsible for handling all the requests from the front end.
 * 3. It is also responsible for handling all the requests from the backend.
 *
 */
@RestController
@RequestMapping("/data")
@EnableFeignClients(basePackageClasses = ApiServiceProxy.class)
public class ApiController implements ApiService {
    private final ApiServiceProxy apiServiceProxy;
    private final FlutterwaveController fwController;


    public ApiController(ApiServiceProxy apiServiceProxy, FlutterwaveController fwController) {
        this.apiServiceProxy = apiServiceProxy;
        this.fwController = fwController;
    }

    @GetMapping(path = "/pay")
    public Object getPaymentdDetails(@RequestParam String email, @RequestParam String ref,@RequestParam(required = false) String transactionType) {
        Content content = getContentByRef(ref);
        User user = getUsersByEmail(email);
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPhone_number(user.getPhone());
        customer.setName(user.getFullname());
        return fwController.payment(content, customer,transactionType);
    }

    @Override
    @GetMapping(path = "/content")
    public Content getContentByRef(@RequestParam("ref") String contentRef) {
        return apiServiceProxy.getContentByRef(contentRef);
    }

    @Override
    @GetMapping("/users")
    public User getUsersByEmail(@RequestParam String email) {
        return apiServiceProxy.getUsersByEmail(email);
    }

}
