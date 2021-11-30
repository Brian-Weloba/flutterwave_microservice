package com.flutterwave.Hamsoace.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface FrontendService {
    @PostMapping("views/{ref}")
    public void view(@PathVariable String ref);
}
