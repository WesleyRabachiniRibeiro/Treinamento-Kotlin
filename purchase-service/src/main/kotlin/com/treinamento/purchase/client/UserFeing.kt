package com.treinamento.purchase.client

import com.treinamento.purchase.DTO.ProdutoDTO
import com.treinamento.purchase.DTO.UsuarioDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "user", url="http://localhost:8070")
interface UserFeing {

    @GetMapping(value = ["/users"])
    fun searchAllUsuarios(@PageableDefault pageable: Pageable) : Page<UsuarioDTO>

    @GetMapping(value = ["/users/{id}"])
    fun searchUsuario(@PathVariable id: Long): UsuarioDTO

}