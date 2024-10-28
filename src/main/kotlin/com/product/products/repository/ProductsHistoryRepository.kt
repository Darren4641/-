package com.product.products.repository

import com.product.products.entity.ProductsHistory
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsHistoryRepository : ReactiveCrudRepository<ProductsHistory, Long> {
}