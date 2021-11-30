package com.flutterwave.Hamsoace.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ConfirmationConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Authorization", "Bearer FLWSECK_TEST-eeec494fe74f06050699687291c401b5-X");

        };
    }
}
