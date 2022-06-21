package com.treinamento.purchase.service

import com.treinamento.purchase.client.ProductFeing
import com.treinamento.purchase.entity.Compra
import com.treinamento.purchase.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService(private val productFeing: ProductFeing, private val repository: CompraRepository) {
//
//    fun buyProduct(compra: Compra) : Compra{
//        val produto = productFeing.searchProduto(compra.produto)
//        if(produto.quantidade < compra.qtdComprado){
//        }
//        compra.valor = produto.valor
//        compra.valorTotal =  compra.qtdComprado.toBigDecimal().multiply(produto.valor)
//        produto.quantidade = produto.quantidade - compra.qtdComprado
//        productFeing.updateProduto(produto, produto.id)
//        return repository.insert(compra)
//    }

}