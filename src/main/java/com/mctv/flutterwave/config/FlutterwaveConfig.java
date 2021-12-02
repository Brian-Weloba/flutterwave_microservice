package com.mctv.flutterwave.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author brianweloba
 * @author hamisiandlae
 * <p>
 * This class is used to configure the request interceptor for the flutterwave api.
 * @see com.mctv.flutterwave.feignclient.FlutterwaveServiceProxy
 */
public class FlutterwaveConfig {
    @Value("${flutterwave.secret-key}")
    private String secretKey;
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer "+ secretKey);

        };
    }
}
