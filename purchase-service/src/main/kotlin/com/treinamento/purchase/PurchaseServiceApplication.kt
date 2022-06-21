package com.treinamento.purchase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PurchaseServiceApplication

fun main(args: Array<String>) {
	runApplication<PurchaseServiceApplication>(*args)
}

