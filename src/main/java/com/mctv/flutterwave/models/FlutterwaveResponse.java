package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity

/**
 * The class Flutterwave response implements serializable. Models the response gotten from the flutterwave api.
 */
public class FlutterwaveResponse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Expose
    private String Status;
    @Expose
    private String tx_ref;
    @Expose
    private String transaction_id;


    /**
     * Flutterwave response
     */
    public FlutterwaveResponse() {

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
     * Gets the status
     *
     * @return the status
     */
    public String getStatus() {

        return Status;
    }


    /**
     * Sets the status
     *
     * @param status the status
     */
    public void setStatus(String status) {

        Status = status;
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
        FlutterwaveResponse that = (FlutterwaveResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(Status, that.Status) && Objects.equals(tx_ref, that.tx_ref) && Objects.equals(transaction_id, that.transaction_id);
    }

    @Override

/**
 *
 * Hash code
 *
 * @return int
 */
    public int hashCode() {

        return Objects.hash(id, Status, tx_ref, transaction_id);
    }


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
     * Gets the transaction_id
     *
     * @return the transaction_id
     */
    public String getTransaction_id() {

        return transaction_id;
    }


    /**
     * Sets the transaction_id
     *
     * @param transaction_id the transaction_id
     */
    public void setTransaction_id(String transaction_id) {

        this.transaction_id = transaction_id;
    }
}
