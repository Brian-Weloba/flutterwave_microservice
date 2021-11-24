package com.flutterwave.Hamsoace.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Customizations implements Serializable {
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String logo;

    public Customizations(String title, String description, String logo) {
        this.title = title;
        this.description = description;
        this.logo = logo;
    }

    //generate getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
