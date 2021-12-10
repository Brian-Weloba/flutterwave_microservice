package com.mctv.flutterwave.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * The FrontendServiceProxy class.
 */
@FeignClient(name = "frontend-service", url = "https://mymovies.africa")
public interface FrontendServiceProxy {
}
