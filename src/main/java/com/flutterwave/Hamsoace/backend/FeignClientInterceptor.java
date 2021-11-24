package com.flutterwave.Hamsoace.backend;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public interface FeignClientInterceptor {

    /**
     * Called for every request. Add data using methods on the supplied RequestTemplate.
     */
   void apply(RequestTemplate template);
}
