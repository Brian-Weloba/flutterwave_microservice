package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.config.FlutterwaveConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * The type Flutterwave service proxy.
 */
@FeignClient(name = "flutterwave-service", url = "https://api.flutterwave.com/v3",configuration = {FlutterwaveConfig.class})
public interface FlutterwaveServiceProxy extends FlutterwaveService {
}
