package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;


/**
 * This is the model class for Data
 * @see Payload
 */
public class Data {
    @Expose
    private String link;


    /**
     *
     * Gets the link
     *
     * @return the link
     */
    public String getLink() {

        return link;
    }


    /**
     *
     * Sets the link
     *
     * @param link  the link
     */
    public void setLink(String link) {

        this.link = link;
    }
}
