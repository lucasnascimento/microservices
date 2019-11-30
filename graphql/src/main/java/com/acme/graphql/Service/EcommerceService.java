package com.acme.graphql.Service;

import java.util.List;

import com.acme.graphql.entity.History;
import com.acme.graphql.entity.Product;
import com.acme.graphql.entity.Sale;
import com.acme.graphql.restclient.RestCLient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcommerceService {

    @Autowired
    RestCLient restCLient;

    public Product getProduct(Long id) {
        return restCLient.getProduct(id);
    }

    public List<Product> getProducts(){
        return restCLient.getProducts();
    }

    public List<History> getHistory (final Long idProduct) {
        return restCLient.getHistory(idProduct);
    }

    public Integer createProduct (final String name, final Double price, final String description, final Integer stock) {
        return restCLient.createProduct(new Product(null, name, price, description, stock));
    }

    public Boolean saleProduct (final Integer productId, final Integer amount) {
        return restCLient.saleProduct(new Sale(productId, amount));
    }
}
