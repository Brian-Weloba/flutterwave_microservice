package com.flutterwave.Hamsoace.payment;


import com.flutterwave.Hamsoace.backend.FrontendService;
import com.flutterwave.Hamsoace.backend.FrontendServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@EnableFeignClients(basePackageClasses = FrontendServiceProxy.class)
public class FrontendController implements FrontendService {
    private FrontendServiceProxy proxy;

    @Autowired
    public FrontendController(FrontendServiceProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void view(String ref) {

    }
}
