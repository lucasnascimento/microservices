package com.acme.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 11/15/19 10:17 AM
 */
@Data
@Builder
@AllArgsConstructor
public class SaleDTO {
    private Long idProduct;
    private Integer amount;
}
