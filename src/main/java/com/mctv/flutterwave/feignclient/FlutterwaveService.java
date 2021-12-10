package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.models.Payload;
import com.mctv.flutterwave.models.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  This is the interface for the FlutterwaveService
 */
public interface FlutterwaveService {

    /**
     * @param payload The payload to be sent to the Flutterwave API
     * @return The response from the Flutterwave API
     *
     * This method is used to send a request to the Flutterwave API that initiates a transaction.
     */
    @PostMapping("/payments")
    @ResponseBody
    Response createPayment(@RequestBody Payload payload);


}
