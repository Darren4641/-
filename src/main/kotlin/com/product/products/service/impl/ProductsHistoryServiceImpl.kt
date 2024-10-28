package com.product.products.service.impl


import com.product.products.operation.ProductsOperation
import com.product.products.repository.ProductsHistoryRepository
import com.product.products.repository.ProductsRepository
import com.product.products.service.ProductsHistoryService
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Service

@Service
class ProductsHistoryServiceImpl (
    val productsRepository: ProductsRepository,
    val productsHistoryRepository: ProductsHistoryRepository,
    val productsOperation: ProductsOperation,
    val reactiveRedisTemplate: ReactiveRedisTemplate<String, String>
) : ProductsHistoryService {

//    @Transactional
//    override fun buyProduct(productsHistoryReq: ProductsHistoryReq): Mono<ProductsHistoryRes> {
//        productsOperation.getTotalStock(reactiveRedisTemplate, productsHistoryReq.id)
//            .switchIfEmpty(
//                productsRepository.findById(productsHistoryReq.id)
//                    .flatMap { product ->
//                        productsOperation.setTotalStock(reactiveRedisTemplate, productsHistoryReq.id, product.totalCount)
//                            .thenReturn(product.totalCount)
//                    }
//            )
//            .flatMap { totalStock ->
//                RedisTransaction.transaction(
//                    reactiveRedisTemplate
//                )
//            }
//    }


}