package com.treinamento.purchase.controller

import com.treinamento.purchase.DTO.ProdutoDTO
import com.treinamento.purchase.client.ProductFeing
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProdutoController(private val productFeing: ProductFeing) {

    @GetMapping
    fun getAllProducts() : List<ProdutoDTO>{
        return productFeing.getAll()
    }

    @GetMapping("{id}")
    fun searchProduto(@PathVariable id : Long) : ProdutoDTO {
        return productFeing.searchProduto(id)
    }
}