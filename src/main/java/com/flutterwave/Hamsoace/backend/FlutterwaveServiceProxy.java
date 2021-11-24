package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "flutterwave-service", url = "https://api.flutterwave.com/v3",configuration = {FeignConfig.class})
public interface FlutterwaveServiceProxy extends FlutterwaveService {
}
