package com.mctv.flutterwave.feignclient;

import com.mctv.flutterwave.models.Content;
import com.mctv.flutterwave.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 *
 * This is the interface for the ApiService.
 */
public interface ApiService {

    /**
     * @param contentRef The content reference.
     * @return The requested content.
     *
     * This method returns the content for the given content reference.
     */
    @PostMapping(path = "api/v1/content",
            consumes = {"application/json",
            "multipart/form-data"})
    @ResponseBody // inside response
    //@ResponeParam ...?email=value
    //@PatrhVariable .../{variable}
    Content getContentByRef(@RequestParam("ref") String contentRef);

    /**
     * @param email The user's email.
     * @return The requested user.
     */
    @PostMapping("api/v1/users/customerid")
    @ResponseBody
    User getUsersByEmail(@RequestParam String email);

    //todo:add endpoint to make a purchase
}
