package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.config.ConfirmationConfig;
import com.flutterwave.Hamsoace.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "confirmation-service", url = "https://api.flutterwave.com/v3/transactions",configuration = {ConfirmationConfig.class})
public interface ConfirmationServiceProxy extends ConfirmationService {
}
