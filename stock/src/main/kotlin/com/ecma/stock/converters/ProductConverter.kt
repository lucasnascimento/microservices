package com.ecma.stock.converters

import com.ecma.stock.dtos.ProductDTO
import com.ecma.stock.entities.History
import com.ecma.stock.entities.Product
import com.ecma.stock.enumeration.Transaction
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors

/**
 * @author s2it_csilva
 * @since 10/1/19 1:21 PM
 * @version : $<br/>
 *          : $
 *
 */
object ProductConverter {
    fun toDTO(entitys: List<Product>): List<ProductDTO> {
        Objects.requireNonNull<List<Product>>(entitys, "vo can't be null!")
        return entitys.stream()
                .map{p-> toDTO(p)}
                .collect(Collectors.toList())
    }

    private fun toDTO(entity: Product): ProductDTO {
        Objects.requireNonNull<Any>(entity, "vo can't be null!")
        return ProductDTO(id = entity.id,
                name = entity.name,
                price = entity.price,
                description = entity.description,
                stock = entity.stock)
    }

    fun toEntity(dto: ProductDTO): Product {
        Objects.requireNonNull<Any>(dto, "vo can't be null!")
        return Product(id = dto.id,
                name = dto.name,
                price = dto.price,
                stock = dto.stock,
                description = dto.description)
    }

    fun toHistory(product: Product): History {
        Objects.requireNonNull<Any>(product, "vo can't be null!")
        return History(date = LocalDateTime.now(),
                transaction = Transaction.PURCHASE,
                quantity = product.stock,
                product = product)
    }
}