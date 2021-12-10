package com.mctv.flutterwave.feignclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Frontend service. This interface connects to the mma-frontend
 */
public interface FrontendService {
    /**
     * @param ref The reference number of the transaction.
     *            <p>
     *            This method returns the view of the content on mma-frontend
     */

    //todo: update the ownership status on the frontend
    @PostMapping("views/{ref}")
    public void view(@PathVariable String ref);
}
