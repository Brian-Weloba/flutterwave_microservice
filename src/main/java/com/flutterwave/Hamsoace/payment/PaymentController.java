package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.models.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public String pay(@ModelAttribute Payload payload, Model model, HttpServletRequest request) throws Exception{
//        if (request.getMethod().contentEquals("GET")){
//            return "redirect:";
//        }
        // TODO: 11/11/2021  this method uko kwa service is not getting data but setting the data.
        paymentService.initialize(model);
        return "pay";
    }



    // get all from our rest api
    @GetMapping(value = "/get")
    public Map<String, Object> getProductList() {
        return paymentService.getTransactions();
    }

    @GetMapping("/callback/{transaction_id}")
    public String callback(@RequestParam Map<String, String> params){
        String transactionId = params.get("transaction_id");
        Map<String, Object> transactionData =
                paymentService.verifyTransaction(transactionId);
        return "callback";
    }

    //get-mapping to test the ui
    // TODO: 11/11/2021  here is working just fine so we'll use it as a test for  any error while building the project
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
