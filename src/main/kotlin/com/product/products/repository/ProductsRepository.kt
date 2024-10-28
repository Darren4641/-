package com.product.products.repository

import com.product.products.entity.Products
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ProductsRepository : ReactiveCrudRepository<Products, Long> {
    fun findByCategory(category: String): Mono<Products>
}