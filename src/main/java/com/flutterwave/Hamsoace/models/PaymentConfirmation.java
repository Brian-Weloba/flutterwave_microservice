package com.flutterwave.Hamsoace.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

//@Entity
public class PaymentConfirmation {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;
    @Expose
    private String status;
    @Expose
    private String message;
    @Expose
    private Object data;

}
