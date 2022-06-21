package com.treinamento.purchase.DTO

import java.math.BigDecimal

data class ProdutoDTO(
    val id : Long,

    val nome : String,

    var quantidade : Int,

    val valor : BigDecimal,

    val descricao : String,

    val active : Boolean,
)