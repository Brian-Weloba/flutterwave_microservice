package com.flutterwave.Hamsoace.config;

import com.flutterwave.Hamsoace.backend.FeignClientInterceptor;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Value("${flutterwave.secret-key}")
    private String secretKey;
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer "+ secretKey);

        };
    }
}
