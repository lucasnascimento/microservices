package com.ecma.stock.controlers

import com.ecma.stock.dtos.HistoryDTO
import com.ecma.stock.dtos.ProductDTO
import com.ecma.stock.services.StockService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stock")
class StockController (
    private val stockService: StockService
) {
    @PostMapping("/save")
    fun addProduct(@RequestBody productDTO: ProductDTO): ResponseEntity<Long> {
        val id = stockService.addProduct(productDTO)
        return ResponseEntity<Long>(id, HttpStatus.OK)
    }

    @GetMapping("/history/{idProduct}")
    fun listHistory(@PathVariable("idProduct") idProduct: Long): ResponseEntity<List<HistoryDTO>> {
        val list = stockService.getHistory(idProduct)
        return ResponseEntity<List<HistoryDTO>>(list, HttpStatus.OK)
    }

    @GetMapping("/history/list")
    fun lisAlltHistory(): ResponseEntity<List<HistoryDTO>> {
        val list = stockService.getHistorys()
        return ResponseEntity<List<HistoryDTO>>(list, HttpStatus.OK)
    }
}
