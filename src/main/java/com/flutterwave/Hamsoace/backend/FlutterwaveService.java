package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.models.Payload;
import com.flutterwave.Hamsoace.models.Response;
import feign.Headers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface FlutterwaveService {

    @PostMapping("/payments")
    @ResponseBody
    Response createPayment(@RequestBody Payload payload);


}
