package com.ecma.stock.dtos

import com.ecma.stock.enumeration.Transaction
import java.time.LocalDateTime

/**
 * @author s2it_csilva
 * @since 11/15/19 10:12 AM
 * @version : $<br/>
 *          : $
 *
 */
data class SaleDTO (
        var idProduct: Long,
        var amount: Int,
        var date: LocalDateTime?,
        var transaction: Transaction?
){
    constructor() : this(0, 0, null, null) {}
}