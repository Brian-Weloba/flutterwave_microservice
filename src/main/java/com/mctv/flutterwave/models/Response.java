package com.mctv.flutterwave.models;


/**
 * The class Response. Model class for the response object.
 */
public class Response {
    private String status;
    private String message;
    private Data data;


    /**
     * Gets the status
     *
     * @return the status
     */
    public String getStatus() {

        return status;
    }


    /**
     * Sets the status
     *
     * @param status the status
     */
    public void setStatus(String status) {

        this.status = status;
    }


    /**
     * Gets the message
     *
     * @return the message
     */
    public String getMessage() {

        return message;
    }


    /**
     * Sets the message
     *
     * @param message the message
     */
    public void setMessage(String message) {

        this.message = message;
    }


    /**
     * Gets the data
     *
     * @return the data
     */
    public Data getData() {

        return data;
    }


    /**
     * Sets the data
     *
     * @param data the data
     */
    public void setData(Data data) {

        this.data = data;
    }
}
