package com.flutterwave.Hamsoace.backend;

import org.springframework.cloud.openfeign.FeignClient;

import static com.flutterwave.Hamsoace.utils.URLs.BASE_URL;

@FeignClient(name="backend-api-service",url = BASE_URL)
public interface ApiServiceProxy extends ApiService {
}
