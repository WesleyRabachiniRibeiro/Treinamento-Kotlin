package com.treinamento.purchase.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*


@Document(collection = "TB_COMPRA")
data class Compra(

    @Id
    val id: String?,

    val usuario: Long,

    val produto: Long,

    val qtdComprado: Int,

    var valor: BigDecimal,

    var valorTotal: BigDecimal,
    )