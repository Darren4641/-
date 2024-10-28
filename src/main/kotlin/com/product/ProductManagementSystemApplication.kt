package com.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
//@ComponentScan(basePackages = ["com.product.*"])
//@EnableR2dbcRepositories(basePackages = ["com.product.*"])
class ProductManagementSystemApplication

fun main(args: Array<String>) {
    runApplication<ProductManagementSystemApplication>(*args)
}
