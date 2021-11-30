package com.flutterwave.Hamsoace.controllers;

import com.flutterwave.Hamsoace.Repositories.PayloadRepository;
import com.flutterwave.Hamsoace.backend.FlutterwaveServiceProxy;
import com.flutterwave.Hamsoace.models.Payload;
import com.flutterwave.Hamsoace.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.flutterwave.Hamsoace.utils.URLs.MICROSERVICE_URL;

@Controller
@EnableFeignClients(basePackageClasses = FlutterwaveServiceProxy.class)
public class ViewController {
    private FlutterwaveServiceProxy proxy;
    private PayloadRepository repo;

    @Autowired
    public ViewController(FlutterwaveServiceProxy proxy, PayloadRepository repo) {
        this.proxy = proxy;
        this.repo = repo;
    }

    @GetMapping(value = "/error",
            produces = {"text/html",
                    "application/json"}
    )
    public String error(@RequestParam String status, @RequestParam String message,@RequestParam String tx_ref, Model model) {
        model.addAttribute("tx_ref", tx_ref);
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        model.addAttribute("url",MICROSERVICE_URL);
        return "error";
    }

    @GetMapping("/retry-payment")
    public ModelAndView retryPayment(@RequestParam String ref) {
        Payload payload = repo.findByRef(ref);
//        payload.setRedirect_url(MICROSERVICE_URL + "/payment-success");
        Response response = proxy.createPayment(payload);
        return new ModelAndView("redirect:" + response.getData().getLink());
    }
}
