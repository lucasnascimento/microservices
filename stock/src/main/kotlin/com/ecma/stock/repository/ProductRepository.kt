package com.ecma.stock.repository

import com.ecma.stock.entities.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<Product, Long>{

}