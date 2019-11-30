package com.ecma.stock.dtos

import java.time.LocalDateTime


data class HistoryDTO(
        var date: LocalDateTime?,
        var transaction: String,
        var quantity: Int,
        var product: String
)
