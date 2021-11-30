package com.flutterwave.Hamsoace.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Meta implements Serializable {
    @Expose
    String contentRef;

    public String getContentRef() {
        return contentRef;
    }

    public void setContentRef(String contentRef) {
        this.contentRef = contentRef;
    }
}
