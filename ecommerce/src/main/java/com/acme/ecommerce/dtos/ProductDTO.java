package com.acme.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 9/27/19 1:20 PM
 */
@Data
@Builder
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer stock;
}
