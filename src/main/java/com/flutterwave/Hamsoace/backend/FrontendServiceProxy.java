package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "frontend-service", url = "https://mymovies.africa")
public interface FrontendServiceProxy {
}
