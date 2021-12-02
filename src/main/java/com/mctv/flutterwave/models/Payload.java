package com.mctv.flutterwave.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Entity

/**
 * The class Payload implements serializable. This class models a payload for the transaction.
 */
public class Payload implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Expose
    private String time;
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
    private String payment_options;
    //    @Expose
//    private String public_key;
    private transient String tx_ref;
    @Expose
    private String ref;
    @Expose
    private String redirect_url;
    @Expose
    private Meta meta;
    @Expose
    private Customizations customizations;

    /**
     * Payload
     */
    public Payload() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        this.time = formattedDateTime;
        this.tx_ref = UUID.randomUUID().toString();
        this.ref = tx_ref;
        Customizations custom = new Customizations("MyMoviesAfrica", "Bring Cinema Home!", "https://mymovies.africa/static/media/mma-logo.885180a6.png");
        this.customizations = custom;
    }

    @Override

/**
 *
 * Equals
 *
 * @param o  the o
 * @return boolean
 */
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return Objects.equals(id, payload.id) && Objects.equals(time, payload.time) && Objects.equals(customer, payload.customer) && Objects.equals(amount, payload.amount) && Objects.equals(currency, payload.currency) && Objects.equals(country, payload.country) && Objects.equals(description, payload.description) && Objects.equals(payment_options, payload.payment_options) && Objects.equals(tx_ref, payload.tx_ref) && Objects.equals(ref, payload.ref) && Objects.equals(redirect_url, payload.redirect_url) && Objects.equals(meta, payload.meta) && Objects.equals(customizations, payload.customizations);
    }

    @Override

/**
 *
 * Hash code
 *
 * @return int
 */
    public int hashCode() {

        return Objects.hash(id, time, customer, amount, currency, country, description, payment_options, tx_ref, ref, redirect_url, meta, customizations);
    }

    /**
     * Gets the meta
     *
     * @return the meta
     */
    public Meta getMeta() {

        return meta;
    }


    /**
     * Sets the meta
     *
     * @param meta the meta
     */
    public void setMeta(Meta meta) {

        this.meta = meta;
    }


    /**
     * Gets the identifier
     *
     * @return the identifier
     */
    public UUID getId() {

        return id;
    }


    /**
     * Sets the identifier
     *
     * @param id the id
     */
    public void setId(UUID id) {

        this.id = id;
    }


    /**
     * Gets the payment_options
     *
     * @return the payment_options
     */
    public String getPayment_options() {

        return payment_options;
    }


    /**
     * Sets the payment_options
     *
     * @param payment_options the payment_options
     */
    public void setPayment_options(String payment_options) {

        this.payment_options = payment_options;
    }


    /**
     * Gets the customizations
     *
     * @return the customizations
     */
    public Customizations getCustomizations() {

        return customizations;
    }


    /**
     * Sets the customizations
     *
     * @param customizations the customizations
     */
    public void setCustomizations(Customizations customizations) {

        this.customizations = customizations;
    }


    /**
     * Gets the customer
     *
     * @return the customer
     */
    public Customer getCustomer() {

        return customer;
    }


    /**
     * Sets the customer
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {

        this.customer = customer;
    }


    /**
     * Gets the amount
     *
     * @return the amount
     */
    public String getAmount() {

        return amount;
    }


    /**
     * Sets the amount
     *
     * @param amount the amount
     */
    public void setAmount(String amount) {

        this.amount = amount;
    }


    /**
     * Gets the currency
     *
     * @return the currency
     */
    public String getCurrency() {

        return currency;
    }


    /**
     * Sets the currency
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {

        this.currency = currency;
    }


    /**
     * Gets the country
     *
     * @return the country
     */
    public String getCountry() {

        return country;
    }


    /**
     * Sets the country
     *
     * @param country the country
     */
    public void setCountry(String country) {

        this.country = country;
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

//    public String getPublic_key() {
//        return public_key;
//    }
//
//    public void setPublic_key(String public_key) {
//        this.public_key = public_key;
//    }


    /**
     * Gets the tx_ref
     *
     * @return the tx_ref
     */
    public String getTx_ref() {

        return tx_ref;
    }


    /**
     * Sets the tx_ref
     *
     * @param tx_ref the tx_ref
     */
    public void setTx_ref(String tx_ref) {

        this.tx_ref = tx_ref;
    }


    /**
     * Gets the redirect_url
     *
     * @return the redirect_url
     */
    public String getRedirect_url() {

        return redirect_url;
    }


    /**
     * Sets the redirect_url
     *
     * @param redirect_url the redirect_url
     */
    public void setRedirect_url(String redirect_url) {

        this.redirect_url = redirect_url;
    }

    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }


    /**
     * Gets the ref
     *
     * @return the ref
     */
    public String getRef() {

        return ref;
    }


    /**
     * Sets the ref
     *
     * @param ref the ref
     */
    public void setRef(String ref) {

        this.ref = ref;
    }


    /**
     * Gets the time
     *
     * @return the time
     */
    public String getTime() {

        return time;
    }


    /**
     * Sets the time
     *
     * @param time the time
     */
    public void setTime(String time) {

        this.time = time;
    }
}
