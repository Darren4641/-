//package com.product.products.repository
//
//import com.product.products.entity.Products
//import org.springframework.data.repository.reactive.ReactiveCrudRepository
//import reactor.core.publisher.Flux
//
//interface ProductsRepository : ReactiveCrudRepository<Products, Long> {
//    fun findByCategory(category: String) : Flux<Products>
//}