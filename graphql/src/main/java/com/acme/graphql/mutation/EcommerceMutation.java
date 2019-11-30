package com.acme.graphql.mutation;

import com.acme.graphql.Service.EcommerceService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcommerceMutation implements GraphQLMutationResolver {

    @Autowired
    private EcommerceService ecommerceService;

    public Integer createProduct(final String name, final Double price, final String description, final Integer stock) {
        return this.ecommerceService.createProduct(name, price, description, stock);
    }

    public Boolean saleProduct(final Integer productId, final Integer amount) {
        return this.ecommerceService.saleProduct(productId, amount);
    }

}
