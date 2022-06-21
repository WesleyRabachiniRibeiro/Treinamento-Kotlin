package com.treinamento.purchase.client

import com.treinamento.purchase.DTO.ProdutoDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "products", url="http://localhost:8080")
interface ProductFeing {

    @GetMapping(value = ["/products"])
    fun getAll() : List<ProdutoDTO>

    @GetMapping(value = ["/products/{id}"])
    fun searchProduto(@PathVariable id: Long): ProdutoDTO

    @PutMapping("{id}")
    fun updateProduto(@RequestBody registry: ProdutoDTO, @PathVariable id: Long): ProdutoDTO
}