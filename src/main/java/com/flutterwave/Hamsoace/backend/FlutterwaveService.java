package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.models.Payload;
import feign.Headers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface FlutterwaveService {

    @PostMapping("/payments")
    @Headers({"Authorization: Bearer FLWSECK_TEST-eeec494fe74f06050699687291c401b5-X",
            "Access-Control-Allow-Origin: *"})
    @ResponseBody
    Object createPayment(@RequestBody Payload payload);


}
