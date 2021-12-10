package com.mctv.flutterwave.feignclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * The interface Confirmation service.
 */
public interface ConfirmationService {
    /**
     * @param id The id of the transaction to be confirmed
     * @return A map containing the transaction details
     *
     * This method confirms a transaction by id
     */
    @GetMapping("{id}/verify")
    @ResponseBody
    Map<String,Object> verify(@PathVariable String id);
}
