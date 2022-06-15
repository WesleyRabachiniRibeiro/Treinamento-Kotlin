package com.treinamento.product.entity

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TB_PRODUTO")
data class Produto(

    @Id
    @Column(name = "cd_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "nm_produto")
    val nome: String,

    @Column(name = "nr_produto")
    val quantidade: Int,

    @Column(name = "vl_produto")
    val valor: BigDecimal,

    @Column(name = "ds_produto")
    val descricao: String,

    @Column(name = "st_produto")
    var isActive: Boolean,

    )