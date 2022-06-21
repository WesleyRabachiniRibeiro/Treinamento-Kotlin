package com.treinamento.purchase.DTO

data class UsuarioDTO (
    var id : Long,

    val nome : String,

    val idade : Int,

    val telefone : String,

    val email : String,

    val senha : String,

    val isActive : Boolean,
)