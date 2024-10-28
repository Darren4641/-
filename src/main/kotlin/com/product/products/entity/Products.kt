package com.product.products.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("products")
class Products (

    val category: String
) {
    @Id
    var id: Long? = null
}



