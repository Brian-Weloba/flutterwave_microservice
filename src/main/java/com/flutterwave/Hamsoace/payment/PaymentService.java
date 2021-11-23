package com.flutterwave.Hamsoace.payment;

import com.flutterwave.Hamsoace.models.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {
    @Value("${flutterwave.public-key}")
    private String ravePublicKey;
    @Value("${flutterwave.secret-key}")
    private String raveSecretKey;

    RestTemplate restTemplate = new RestTemplate();



    public  void initialize(Model model) throws Exception{
        model.addAttribute("url", "https://checkout.flutterwave/v3.js");
//        model.getAttribute("url", "https://checkout.flutterwave/v3.js")
        Payload payload =  (Payload) model.getAttribute("payload");
        if (payload == null){
            throw new Exception("Payload is empty");
        }
        addRaveDetailsToPayload(payload);
        model.addAttribute("payload", payload);
    }


    // my method for the getting mapping
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://checkout.flutterwave/v3.js", HttpMethod.GET, entity, String.class).getBody();
    }

    private String hashSHA256(String originalString) throws Exception{
        MessageDigest digest =  MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8)
        );
        return bytesToHex(encodedHash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for(byte b : hash){
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private void addRaveDetailsToPayload(Payload payload) {
        String txRef = UUID.randomUUID().toString();
        payload.setAmount(payload.getAmount());
        payload.setCurrency(payload.getCurrency());
        payload.setPayment_method(payload.getPayment_method());
        payload.setPublic_key(ravePublicKey);
        payload.setTx_ref(txRef);
        payload.setCustomer(payload.getCustomer());
        payload.setRedirect_url("/callback");
    }

    public Map<String, Object> verifyTransaction(String transactionId){
        String url = "https://api.flutterwave.com/v3/transactions/" + transactionId + "/verify";
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(raveSecretKey);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<>(){

        };
        ResponseEntity<Map<String, Object>> response = rest.exchange(
                url, HttpMethod.GET, httpEntity, typeRef
        );
        return response.getBody();
    }

    // this one should work some bug fixing needed here
     public Map<String, Object> getTransactions() {
         String url = "https://api.flutterwave.com/v3/callback/";
         RestTemplate rest = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setBearerAuth(raveSecretKey);
         HttpEntity<String> httpEntity = new HttpEntity<>(headers);
         ParameterizedTypeReference<Map<String, Object>> typeRef = new ParameterizedTypeReference<>() {};
         ResponseEntity<Map<String, Object>> response = rest.exchange(
                 url, HttpMethod.GET, httpEntity, typeRef
         );
         return response.getBody();
     }

}
