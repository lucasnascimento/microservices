package com.ecma.stock.services

import com.ecma.stock.constants.RabbitConstants
import com.ecma.stock.converters.HistoryConverter
import com.ecma.stock.dtos.SaleDTO
import com.ecma.stock.enumeration.Transaction
import com.ecma.stock.repository.HistoryRepository
import com.ecma.stock.repository.ProductRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class HistoryService (
        private val historyRepository: HistoryRepository,
        private val productRepository: ProductRepository
) {

    @RabbitListener(queues = [RabbitConstants.SALE_QUEUE])
    fun consumer(saleDTO: SaleDTO){
        saleDTO.transaction = Transaction.SALE
        saleDTO.date = LocalDateTime.now()
        val product = productRepository.findById(saleDTO.idProduct)
        if(product.isPresent){
           historyRepository.save(HistoryConverter.toHistoryEntity(saleDTO, product.get()))
        }
    }
}