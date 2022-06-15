package com.treinamento.user.controllers.dto

import com.treinamento.user.entity.Endereco
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RegistroUsuarioDTO (

    @field:NotEmpty
    val nome : String,

    @field:NotNull
    val idade : Int,

    @field:NotEmpty
    val telefone : String,

    @field:NotEmpty
    val email : String,

    @field:NotEmpty
    val senha : String,

    val isActive : Boolean,
)