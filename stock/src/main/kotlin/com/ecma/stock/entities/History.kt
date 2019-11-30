package com.ecma.stock.entities

import com.ecma.stock.enumeration.Transaction
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class History(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        val date: LocalDateTime?,

        val transaction: Transaction?,

        val quantity: Int,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ID_PRODUCT")
        val product: Product
)