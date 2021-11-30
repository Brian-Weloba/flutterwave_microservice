package com.flutterwave.Hamsoace.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
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

    public FlutterwaveResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlutterwaveResponse that = (FlutterwaveResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(Status, that.Status) && Objects.equals(tx_ref, that.tx_ref) && Objects.equals(transaction_id, that.transaction_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Status, tx_ref, transaction_id);
    }

    public String getTx_ref() {
        return tx_ref;
    }

    public void setTx_ref(String tx_ref) {
        this.tx_ref = tx_ref;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}
