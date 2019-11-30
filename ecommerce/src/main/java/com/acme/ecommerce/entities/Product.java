package com.acme.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/26/19 1:33 PM
 */
@Data
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String description;

    private int stock;

}
