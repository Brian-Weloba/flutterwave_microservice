package com.flutterwave.Hamsoace.models;

import com.google.gson.annotations.Expose;

public class Data {
    @Expose
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
