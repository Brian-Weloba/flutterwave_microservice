package com.flutterwave.Hamsoace.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

public interface ConfirmationService {
    @GetMapping("{id}/verify")
    @ResponseBody
    Map<String,Object> verify(@PathVariable String id);
}
