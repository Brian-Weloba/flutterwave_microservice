package com.flutterwave.Hamsoace.backend;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="backend-api-service",url = "https://1f19-102-23-104-196.ngrok.io")
public interface ApiServiceProxy extends ApiService {
}
