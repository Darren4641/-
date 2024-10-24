package com.product.products.handler


import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ProductsHandler (
    //private val productsRepository: ProductsRepository
) {

    fun getAllProducts(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body(Mono.just("hello world"), String::class.java)
    }

}