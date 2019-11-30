package com.ecma.stock.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author s2it_csilva
 * @since 10/1/19 12:58 PM
 * @version : $<br/>
 *          : $
 *
 */
@Entity
data class Product (

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long? = null,
        val name: String,
        val price: Double? = null,
        val description: String? = null,
        var stock: Int = 0
){
    data class Builder(
            var id: Long? = null,
            var name: String,
            var price: Double? = null,
            var description: String? = null,
            var stock: Int = 0) {

        fun id(id: Long?) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun price(price: Double?) = apply { this.price = price }
        fun description(description: String?) = apply { this.description = description }
        fun stock(stock: Int) = apply { this.stock = stock }
        fun build() = Product(id, name, price, description, stock)
    }
}