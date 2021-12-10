package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;


/**
 * The class Customizations implements serializable
 *
 * @see Payload
 */
public class Customizations implements Serializable {
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String logo;


    /**
     * Customizations
     *
     * @param title       the title
     * @param description the description
     * @param logo        the logo url
     *                    <p>
     *                    Constructor for Customizations
     */
    public Customizations(String title, String description, String logo) {

        this.title = title;
        this.description = description;
        this.logo = logo;
    }

    //generate getters and setters

    /**
     * Gets the title
     *
     * @return the title
     */
    public String getTitle() {

        return title;
    }


    /**
     * Sets the title
     *
     * @param title the title
     */
    public void setTitle(String title) {

        this.title = title;
    }


    /**
     * Gets the description
     *
     * @return the description
     */
    public String getDescription() {

        return description;
    }


    /**
     * Sets the description
     *
     * @param description the description
     */
    public void setDescription(String description) {

        this.description = description;
    }


    /**
     * Gets the logo url
     *
     * @return the logo url
     */
    public String getLogo() {

        return logo;
    }


    /**
     * Sets the logo url
     *
     * @param logo the logo url
     */
    public void setLogo(String logo) {

        this.logo = logo;
    }
}
