package com.flutterwave.Hamsoace.models;

import com.flutterwave.Hamsoace.models.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Payload implements Serializable {
    @Expose
    private Customer customer;
    @Expose
    private String amount;
    @Expose
    private String currency;
    @Expose
    private String country;
    @Expose
    private String description;
    @Expose
    private String payment_method;
    @Expose
    private String public_key;
    @Expose
    private String tx_ref;
    @Expose
    private String redirect_url;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getTx_ref() {
        return tx_ref;
    }

    public void setTx_ref(String tx_ref) {
        this.tx_ref = tx_ref;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "customer=" + customer +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", public_key='" + public_key + '\'' +
                ", tx_ref='" + tx_ref + '\'' +
                ", redirect_url='" + redirect_url + '\'' +
                '}';
    }
}
