package com.flutterwave.Hamsoace.utils;

import org.springframework.beans.factory.annotation.Value;

public class URLs {

    //1. Base URL
    public static final String BASE_URL = "https://342e-102-222-146-74.ngrok.io";
    //2. Microservice URL
    public static final String MICROSERVICE_URL = "https://5367-102-222-146-74.ngrok.io";
    //3. API Key
    @Value("${rave.api.key}")
    public static String API_KEY;
}
