package com.product.products.router

import com.product.products.handler.ProductsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class ProductsRouter {

    @Bean
    fun route(productsHandler: ProductsHandler) : RouterFunction<ServerResponse> {
        return RouterFunctions
            .route()
            .GET("/products", productsHandler::getAllProducts)
            .build()
    }
}