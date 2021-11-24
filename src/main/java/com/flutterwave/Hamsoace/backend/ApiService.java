package com.flutterwave.Hamsoace.backend;

import com.flutterwave.Hamsoace.models.Content;
import com.flutterwave.Hamsoace.models.ContentRef;
import com.flutterwave.Hamsoace.models.Customer;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ApiService {

    @PostMapping(path = "api/v1/content",
            consumes = {"application/json",
            "multipart/form-data"})
    @ResponseBody // inside response
    //@ResponeParam ...?email=value
    //@PatrhVariable .../{variable}
    Content getContentByRef(@RequestParam("ref") String contentRef);

    @PostMapping("api/v1/users/customerid")
    @ResponseBody
    Customer getUsersByEmail(@RequestParam String email);
}
