package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.config.ConfirmationConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * The type Confirmation service proxy.
 */
@FeignClient(name = "confirmation-service", url = "https://api.flutterwave.com/v3/transactions",configuration = {ConfirmationConfig.class})
public interface ConfirmationServiceProxy extends ConfirmationService {
}
