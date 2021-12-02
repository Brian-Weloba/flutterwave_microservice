package com.flutterwave.Hamsoace.utils;

import org.springframework.beans.factory.annotation.Value;

public class URLs {

    //1. Base URL
    public static final String BASE_URL = "https://b248-105-21-41-70.ngrok.io";
    //2. Microservice URL
    public static final String MICROSERVICE_URL = "https://localhost:8081";
    //3. API Key
    @Value("${rave.api.key}")
    public static String API_KEY;
}
