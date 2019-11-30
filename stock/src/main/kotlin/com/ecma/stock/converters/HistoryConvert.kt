package com.ecma.stock.converters

import com.ecma.stock.dtos.HistoryDTO
import com.ecma.stock.dtos.SaleDTO
import com.ecma.stock.entities.History
import com.ecma.stock.entities.Product
import com.ecma.stock.enumeration.Transaction
import java.util.*
import java.util.stream.Collectors

object HistoryConverter {
    fun toHistoryEntity(dto: SaleDTO, product: Product): History {
        Objects.requireNonNull<Any>(dto, "vo can't be null!")
        return History(
                quantity = dto.amount,
                date = dto.date,
                product = product,
                transaction = dto.transaction)
    }

    fun toDTO(entities: List<History>): List<HistoryDTO>{
        return entities.stream()
                .map{p-> toDTO(p) }
                .collect(Collectors.toList())
    }

    private fun toDTO(entity: History): HistoryDTO{
        Objects.requireNonNull<Any>(entity, "vo can't be null!")
        return HistoryDTO(
                quantity = entity.quantity,
                transaction = if (entity.transaction == Transaction.PURCHASE) "PURCHASE" else "SALE",
                date = entity.date,
                product = entity.product.name)
    }
}