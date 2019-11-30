package com.acme.graphql.entity;

import java.io.Serializable;

public class Product implements Serializable {

    private Long id;

    private String name;

    private Double price;

    private String description;

    private int stock;

    public Product () { }

    public Product (final Long id, final String name, final Double price, final String description, final int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Long getId () {
        return id;
    }

    public void setId (final Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (final Double price) {
        this.price = price;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (final String description) {
        this.description = description;
    }

    public int getStock () {
        return stock;
    }

    public void setStock (final int stock) {
        this.stock = stock;
    }
}
