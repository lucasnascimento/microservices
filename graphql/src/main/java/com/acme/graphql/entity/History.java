package com.acme.graphql.entity;

import java.io.Serializable;

public class History implements Serializable{
    String date;
    String transaction;
    Integer quantity;
    String product;

    public String getDate () {
        return date;
    }

    public void setDate (final String date) {
        this.date = date;
    }

    public String getTransaction () {
        return transaction;
    }

    public void setTransaction (final String transaction) {
        this.transaction = transaction;
    }

    public Integer getQuantity () {
        return quantity;
    }

    public void setQuantity (final Integer quantity) {
        this.quantity = quantity;
    }

    public String getProduct () {
        return product;
    }

    public void setProduct (final String product) {
        this.product = product;
    }
}
