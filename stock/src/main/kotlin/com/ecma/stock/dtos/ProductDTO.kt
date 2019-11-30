package com.ecma.stock.dtos

data class ProductDTO (
        var id: Long? = null,
        var name: String,
        var price: Double? = null,
        var description: String? = null,
        var stock: Int = 0
)
