package com.mctv.flutterwave.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * This class is used to configure the request interceptor for the confirmation api.
 * @see com.mctv.flutterwave.feignclient.ConfirmationServiceProxy
 */
public class ConfirmationConfig {
    @Value("${flutterwave.secret-key}")
    private String secretKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Authorization", "Bearer " + secretKey);

        };
    }
}
