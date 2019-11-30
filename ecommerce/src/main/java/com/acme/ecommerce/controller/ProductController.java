package com.acme.ecommerce.controller;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import com.acme.ecommerce.dtos.ProductDTO;
import com.acme.ecommerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:18 PM
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices services;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> result = services.listAll();
        if (isNull(result)) {
            return new ResponseEntity(ResponseEntity.notFound().build(), NOT_FOUND);
        }
        return new ResponseEntity<>(result, OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("idProduct") Long idProduct) {
        ProductDTO result = services.getProduct(idProduct);
        if (isNull(result)) {
            return new ResponseEntity(ResponseEntity.notFound().build(), NOT_FOUND);
        }
        return new ResponseEntity<>(result, OK);
    }
}
