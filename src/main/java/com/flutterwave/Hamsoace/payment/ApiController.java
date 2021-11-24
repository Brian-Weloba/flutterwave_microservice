package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.backend.ApiService;
import com.flutterwave.Hamsoace.backend.ApiServiceProxy;
import com.flutterwave.Hamsoace.models.Content;
import com.flutterwave.Hamsoace.models.Customer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@EnableFeignClients(basePackageClasses = ApiServiceProxy.class)
public class ApiController implements ApiService {
    private ApiServiceProxy apiServiceProxy;
    private FlutterwaveController fwController;

    public ApiController(ApiServiceProxy apiServiceProxy, FlutterwaveController fwController) {
        this.apiServiceProxy = apiServiceProxy;
        this.fwController = fwController;
    }

    @GetMapping(path = "/pay")
    public Object getPaymentdDetails(@RequestParam String email, @RequestParam String ref) {
        Content content = getContentByRef(ref);
        Customer customer = getUsersByEmail(email);
        return fwController.payment(content, customer);
    }

    @Override
    @GetMapping(path = "/content")
    public Content getContentByRef(@RequestParam("ref") String contentRef) {
        return apiServiceProxy.getContentByRef(contentRef);
    }

    @Override
    @GetMapping("/users")
    public Customer getUsersByEmail(@RequestParam String email) {
        Customer customer = apiServiceProxy.getUsersByEmail(email);
        customer.setEmail(email);
        customer.setName("Hamsoace");
        customer.setPhone_number("08031234567");
        return customer;
    }

}
