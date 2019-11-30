package com.acme.graphql.query;

import java.util.List;

import com.acme.graphql.Service.EcommerceService;
import com.acme.graphql.entity.History;
import com.acme.graphql.entity.Product;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcommerceQuery implements GraphQLQueryResolver {

    @Autowired
    private EcommerceService ecommerceService;

    public Product getProduct(Long idProduct) {
        return ecommerceService.getProduct(idProduct);
    }

    public List<Product> getProducts() {
        return ecommerceService.getProducts();
    }

    public List<History> getHistory(Long idProduct) {
        return ecommerceService.getHistory(idProduct);
    }





}
