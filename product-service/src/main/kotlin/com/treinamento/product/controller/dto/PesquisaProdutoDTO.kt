package com.treinamento.product.controller.dto

import java.math.BigDecimal

data class PesquisaProdutoDTO(
    val id : Long?,

    val nome : String,

    val quantidade : Int,

    val valor : BigDecimal,

    val descricao : String,

    val isActive : Boolean,
)