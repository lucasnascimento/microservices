package com.acme.ecommerce.converters;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.acme.ecommerce.dtos.SaleDTO;
import com.acme.ecommerce.dtos.ProductDTO;
import com.acme.ecommerce.entities.Product;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:25 PM
 */
public class ProductConverter {

    public static List<ProductDTO> toDTO (final List<Product> entitys) {
        Objects.requireNonNull(entitys, "vo can't be null!");
        return entitys.stream().map(ProductConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static ProductDTO toDTO (final Product entity) {
        Objects.requireNonNull(entity, "vo can't be null!");
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .description(entity.getDescription()).build();
    }

    public static SaleDTO toSaleDTO (final Integer quantity, Long idProduct) {
        return SaleDTO.builder()
                .idProduct(idProduct)
                .amount(quantity).build();
    }
}
