package com.mctv.flutterwave.models;


/**
 * The class User. Model class for User.
 */
public class User {
    private String id;
    private String phone;
    private String fullname;


    /**
     * Gets the identifier
     *
     * @return the identifier
     */
    public String getId() {

        return id;
    }


    /**
     * Sets the identifier
     *
     * @param id the id
     */
    public void setId(String id) {

        this.id = id;
    }


    /**
     * Gets the phone
     *
     * @return the phone
     */
    public String getPhone() {

        return phone;
    }


    /**
     * Sets the phone
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {

        this.phone = phone;
    }


    /**
     * Gets the fullname
     *
     * @return the fullname
     */
    public String getFullname() {

        return fullname;
    }


    /**
     * Sets the fullname
     *
     * @param fullname the fullname
     */
    public void setFullname(String fullname) {

        this.fullname = fullname;
    }
}
