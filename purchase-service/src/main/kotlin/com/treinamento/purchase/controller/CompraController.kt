package com.treinamento.purchase.controller

import com.treinamento.purchase.DTO.PesquisarCompraDTO
import com.treinamento.purchase.DTO.RegistrarCompraDTO
import com.treinamento.purchase.mapper.CompraMapper
import com.treinamento.purchase.service.CompraService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId
import java.util.*

@RestController
@RequestMapping("/purchases")
class CompraController(private val service : CompraService) {

//    @PostMapping
//    fun buy(@RequestBody request : RegistrarCompraDTO) : PesquisarCompraDTO {
//        val compra = service.buyProduct(CompraMapper.fromDTO(request))
//        System.out.println(CompraMapper.fromEntity(compra))
//        return CompraMapper.fromEntity(compra)
//    }

    @GetMapping("{id}")
    fun userAllPurchases(@PathVariable id : Long): String {
            return "Hello World"
    }

    @GetMapping("{id}/{idPurchase}")
    fun userPurchases(@PathVariable id : Long, @PathVariable idPurchase : UUID){

    }
}