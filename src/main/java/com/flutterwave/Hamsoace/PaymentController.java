package com.flutterwave.Hamsoace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @RequestMapping("/pay")
    public String pay(@ModelAttribute Payload payload, Model model, HttpServletRequest request) throws Exception{
        if (request.getMethod().contentEquals("GET")){
            return "redirect:";
        }
        paymentService.initialize(model);
        return "pay";
    }

    @GetMapping("/callback")
    public String callback(@RequestParam Map<String, String> params){
        String transactionId = params.get("transaction_id");
        Map<String, Object> transactionData =
                paymentService.verifyTransaction(transactionId);
        return "callback";
    }
}
