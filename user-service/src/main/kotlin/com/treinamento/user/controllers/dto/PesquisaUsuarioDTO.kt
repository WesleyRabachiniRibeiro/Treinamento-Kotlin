package com.treinamento.user.controllers.dto

import com.treinamento.user.entity.Endereco

data class PesquisaUsuarioDTO(
    var id : Long?,

    val nome : String,

    val idade : Int,

    val telefone : String,

    val email : String,

    val senha : String,

    val isActive : Boolean,
)