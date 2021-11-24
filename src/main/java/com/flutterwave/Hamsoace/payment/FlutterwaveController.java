package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.backend.FlutterwaveService;
import com.flutterwave.Hamsoace.backend.FlutterwaveServiceProxy;
import com.flutterwave.Hamsoace.models.Content;
import com.flutterwave.Hamsoace.models.Customer;
import com.flutterwave.Hamsoace.models.Payload;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = FlutterwaveServiceProxy.class)
public class FlutterwaveController implements FlutterwaveService {
    private FlutterwaveServiceProxy proxy;

    public FlutterwaveController(FlutterwaveServiceProxy proxy) {
        this.proxy = proxy;
    }


    @GetMapping("/payment")
    public Object payment(Content content, Customer customer) {
        Payload payload = new Payload();
        //if est or rental or pvod
        String amount = content.getEst();
        payload.setAmount(amount);
        //
        payload.setPayment_options("card");
        payload.setRedirect_url("https://7d60-102-23-104-196.ngrok.io/flutterwave/callback");
        payload.setCustomer(customer);
        payload.setCurrency(content.getCurrency());
        return proxy.createPayment(payload);
    }

    @GetMapping(path = "/callback")
    public Object paymentCallback(@RequestParam String status,@RequestParam String tx_ref, @RequestParam String transaction_id) {
        //todo:get transaction details from database
        if(status.equals("successful") ){
            //todo:handle successful payment
            //todo:save to database
            //todo:redirect to view content & update backend
            return "redirect to view content";
        }else{
            //todo:handle transaction errors
            return "error making purchase";
        }
    }


    @Override
    public Object createPayment(Payload payload) {
        return proxy.createPayment(payload);
    }
}
