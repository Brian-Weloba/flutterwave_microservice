package com.flutterwave.Hamsoace.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Payload implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Expose
    private String time;
    @Expose
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return Objects.equals(id, payload.id) && Objects.equals(time, payload.time) && Objects.equals(customer, payload.customer) && Objects.equals(amount, payload.amount) && Objects.equals(currency, payload.currency) && Objects.equals(country, payload.country) && Objects.equals(description, payload.description) && Objects.equals(payment_options, payload.payment_options) && Objects.equals(tx_ref, payload.tx_ref) && Objects.equals(ref, payload.ref) && Objects.equals(redirect_url, payload.redirect_url) && Objects.equals(meta, payload.meta) && Objects.equals(customizations, payload.customizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, customer, amount, currency, country, description, payment_options, tx_ref, ref, redirect_url, meta, customizations);
    }

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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(String payment_options) {
        this.payment_options = payment_options;
    }

    public Customizations getCustomizations() {
        return customizations;
    }

    public void setCustomizations(Customizations customizations) {
        this.customizations = customizations;
    }


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

//    public String getPublic_key() {
//        return public_key;
//    }
//
//    public void setPublic_key(String public_key) {
//        this.public_key = public_key;
//    }

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
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
