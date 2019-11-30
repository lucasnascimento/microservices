package com.ecma.stock.repository

import com.ecma.stock.entities.History
import com.ecma.stock.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author s2it_csilva
 * @since 11/15/19 10:40 AM
 * @version : $<br/>
 *          : $
 *
 */
interface HistoryRepository : JpaRepository<History, Long> {

    fun findByProduct(product: Product): List<History>

}