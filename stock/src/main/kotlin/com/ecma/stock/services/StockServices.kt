package com.ecma.stock.services

import com.ecma.stock.constants.RabbitConstants
import com.ecma.stock.converters.HistoryConverter
import com.ecma.stock.converters.ProductConverter
import com.ecma.stock.dtos.HistoryDTO
import com.ecma.stock.dtos.ProductDTO
import com.ecma.stock.repository.HistoryRepository
import com.ecma.stock.repository.ProductRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service


@Service
class StockService  (
    private val productRepository: ProductRepository,
    private val historyRepository: HistoryRepository,
    private val rabbitTemplate: RabbitTemplate
) {
    fun addProduct(productDTO: ProductDTO): Long? {
        val product = productRepository.save(ProductConverter.toEntity(productDTO))
        historyRepository.save(ProductConverter.toHistory(product))
        rabbitTemplate.convertAndSend(RabbitConstants.PRODUCT_EX, "", product)
        return product.id
    }

    fun getHistory(idProduct: Long): List<HistoryDTO> {
        var product = productRepository.findById(idProduct)
        if(product.isPresent) {
            return HistoryConverter.toDTO(historyRepository.findByProduct(product.get()))
        }else{
            return emptyList()
        }
    }

    fun getHistorys(): List<HistoryDTO> {
        return HistoryConverter.toDTO(historyRepository.findAll())
    }
}