package edu.tcu.cs.onlineshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Ewallet implements Serializable {
    @Id
    private String id = null;
    private double balance = -1.0;
    private String timeCreate = null;
    private String timeModify = null;
    private String status = null;

    public Ewallet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getTimeModify() {
        return timeModify;
    }

    public void setTimeModify(String timeModify) {
        this.timeModify = timeModify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}