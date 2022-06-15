package com.treinamento.product.repository

import com.treinamento.product.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProdutoRepository : JpaRepository<Produto, Long>{

    @Query("SELECT a FROM Produto a where a.isActive = true")
    fun findProdutosByIsActive() : List<Produto>
}