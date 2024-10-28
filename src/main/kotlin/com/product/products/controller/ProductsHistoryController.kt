//package com.product.products.controller
//
//import com.product.common.response.BaseResponse
//import com.product.products.dto.ProductsHistoryReq
//import com.product.products.dto.ProductsHistoryRes
//import com.product.products.service.ProductsHistoryService
//import jakarta.validation.Valid
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//import reactor.core.publisher.Mono
//
//@RestController
//@RequestMapping("/product-history")
//class ProductsHistoryController (
//    val productsHistoryService: ProductsHistoryService
//) {
//
//
//    @PostMapping("")
//    fun buyProduct(@Valid @RequestBody productsHistoryReq: Mono<ProductsHistoryReq>) : Mono<BaseResponse<ProductsHistoryRes>> {
//        return productsHistoryReq
//            .flatMap { product ->
//                productsHistoryService.buyProduct(product)
//            }
//            .map { res -> BaseResponse(data = res) }
//    }
//}