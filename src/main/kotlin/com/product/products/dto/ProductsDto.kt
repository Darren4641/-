package com.product.products.dto

import com.product.products.entity.Products
import jakarta.validation.constraints.NotBlank

class ProductsCreateReq (
    @field:NotBlank(message = "Category는 필수 값입니다.")
    var category: String,
    @field:NotBlank(message = "Type은 필수 값입니다.")
    var type: String
) {
    fun toEntity() : Products = Products(category = category)
}

class ProductsCreateRes (
    val id: Long,
    val category: String
)

class ProductDto (
    val id: Long,
    val category: String
)