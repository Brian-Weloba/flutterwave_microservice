package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.backend.ConfirmationService;
import com.flutterwave.Hamsoace.backend.ConfirmationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/flutterwave")
@EnableFeignClients(basePackageClasses = ConfirmationServiceProxy.class)
public class ConfirmationController implements ConfirmationService {

    private final ConfirmationServiceProxy proxy;

    @Autowired
    public ConfirmationController(ConfirmationServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping(path="/confirmation/{id}",
    produces = {"application/json","text/html"})
    public String confirm(@PathVariable("id") String txId) {

        //todo: confirm transaction before updating
        Map<String, Object> response = proxy.verify(txId);
        if (response.get("status").equals("successful")) {
            //todo:update backend
            return "success";
        } else {
            //todo:wait and try again 3 times
            return "failed";

        }
    }

    @Override
    public Map<String, Object> verify(String id) {
        return proxy.verify(id);
    }
}
