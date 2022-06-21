package com.treinamento.purchase.DTO

import java.math.BigDecimal

data class PesquisarCompraDTO(
    val id: String?,

    val usuario: Long,

    val produto: Long,

    val qtdComprado: Int,

    val valor: BigDecimal,

    val valorTotal: BigDecimal,
)