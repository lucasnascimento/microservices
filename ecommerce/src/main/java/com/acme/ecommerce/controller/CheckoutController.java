package com.acme.ecommerce.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

import com.acme.ecommerce.dtos.SaleDTO;
import com.acme.ecommerce.exceptions.EstockInsufficientException;
import com.acme.ecommerce.exceptions.ProductNotFoundException;
import com.acme.ecommerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:37 PM
 */
@RestController
@RequestMapping("/checkout")

public class CheckoutController {

    @Autowired
    private ProductServices services;

    @PostMapping("/sale")
    public ResponseEntity<Boolean> sale(@RequestBody SaleDTO saleDTO) {
        try{
            services.saleProduct(saleDTO.getIdProduct(), saleDTO.getAmount());
        }catch (ProductNotFoundException p){
            return new ResponseEntity<>(false, NOT_FOUND);
        }catch (EstockInsufficientException e){
            return new ResponseEntity<>(false, PRECONDITION_FAILED);
        }
        return new ResponseEntity<>(true, OK);
    }
}
