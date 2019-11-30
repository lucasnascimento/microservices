package com.acme.graphql.entity;

import java.io.Serializable;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 11/16/19 3:37 PM
 */
public class Sale implements Serializable {

    private Integer idProduct;

    private Integer amount;

    public Sale () { }

    public Sale (final Integer idProduct, final Integer amount) {
        this.idProduct = idProduct;
        this.amount = amount;
    }

    public Integer getIdProduct () {
        return idProduct;
    }

    public void setIdProduct (final Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getAmount () {
        return amount;
    }

    public void setAmount (final Integer amount) {
        this.amount = amount;
    }
}
