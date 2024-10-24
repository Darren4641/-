package com.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductManagementSystemApplication

fun main(args: Array<String>) {
    runApplication<ProductManagementSystemApplication>(*args)
}
