package com.product.products.service

import com.product.products.dto.ProductDto
import com.product.products.dto.ProductsCreateRes
import com.product.products.entity.Products
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProductsService {
    fun createProduct(products: Products) : Mono<ProductsCreateRes>

    fun getAllProducts() : Flux<ProductDto>

    fun deleteProduct(id: Long) : Mono<ProductDto>
}