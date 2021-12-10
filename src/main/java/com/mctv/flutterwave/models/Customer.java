package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;


/**
 * The class Customer implements serializable
 * @see Payload
 */
public class Customer implements Serializable {
    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String phone_number;


    /**
     * Gets the name
     *
     * @return the name
     */
    public String getName() {

        return name;
    }


    /**
     * Sets the name
     *
     * @param name the name
     */
    public void setName(String name) {

        this.name = name;
    }


    /**
     * Gets the email
     *
     * @return the email
     */
    public String getEmail() {

        return email;
    }


    /**
     * Sets the email
     *
     * @param email the email
     */
    public void setEmail(String email) {

        this.email = email;
    }


    /**
     * Gets the phone_number
     *
     * @return the phone_number
     */
    public String getPhone_number() {

        return phone_number;
    }


    /**
     * Sets the phone_number
     *
     * @param phone_number the phone_number
     */
    public void setPhone_number(String phone_number) {

        this.phone_number = phone_number;
    }
}

