package com.flutterwave.Hamsoace;

import com.flutterwave.Hamsoace.models.Response;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.BadRequest.class)
    public String handleFeignException(FeignException e, HttpServletResponse response) {
        response.setStatus(200);
        return e.contentUTF8();
    }
}
