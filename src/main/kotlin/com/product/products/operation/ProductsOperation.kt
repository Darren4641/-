package com.product.products.operation

import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


@Component
class ProductsOperation (
    private val reactiveRedisTemplate: ReactiveRedisTemplate<String, String>
) {

    private val keyPrefix = "products"

    fun getHistoryCount(reactiveRedisTemplate: ReactiveRedisTemplate<String, String>, productId: Long): Mono<Long> {
        val key = "$keyPrefix:history:$productId"
        return reactiveRedisTemplate.opsForSet().size(key)
    }

    fun addHistoryRecord(reactiveRedisTemplate: ReactiveRedisTemplate<String, String>, productId: Long, userId: String): Mono<Boolean> {
        val key = "$keyPrefix:history:$productId"
        return reactiveRedisTemplate.opsForSet().add(key, userId).map { it > 0 }
    }

    fun setTotalStock(reactiveRedisTemplate: ReactiveRedisTemplate<String, String>, productId: Long, totalCount: Long): Mono<Boolean> {
        val key = "$keyPrefix:stock:$productId"
        return reactiveRedisTemplate.opsForValue().set(key, totalCount.toString()).thenReturn(true)
    }

    fun getTotalStock(reactiveRedisTemplate: ReactiveRedisTemplate<String, String>, productId: Long): Mono<Long> {
        val key = "$keyPrefix:stock:$productId"
        return reactiveRedisTemplate.opsForValue().get(key).map { it?.toLong() ?: 0 }
    }

}