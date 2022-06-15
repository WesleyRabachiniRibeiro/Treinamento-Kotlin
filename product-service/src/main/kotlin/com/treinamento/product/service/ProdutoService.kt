package com.treinamento.product.service

import com.treinamento.product.entity.Produto
import com.treinamento.product.repository.ProdutoRepository
import com.treinamento.user.exceptions.StatusException
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Service
class ProdutoService(private val repository : ProdutoRepository) {

    fun saveProduto(produto: Produto) : Produto{
        return repository.save(produto)
    }

    fun searchProduto(id: Long): Produto {
        val produto: Optional<Produto> = repository.findById(id)
        return produto.orElseThrow()
    }

    fun listAllActiveProduct() : List<Produto> {
        return repository.findProdutosByIsActive()
    }

    fun disableProduct(id : Long) : Produto{
        val produto = searchProduto(id)
        if (!produto.isActive){
            throw StatusException(produto.isActive)
        }
        produto.isActive = false
        return repository.save(produto)
    }

    fun ableProduct(id : Long) : Produto{
        val produto = searchProduto(id)
        if (produto.isActive){
            throw StatusException(produto.isActive)
        }
        produto.isActive = true
        return repository.save(produto)
    }

    fun updateProduto(produto: Produto, id : Long) : Produto{
        val initialProduto : Produto = this.searchProduto(id)
        produto.id = initialProduto.id
        return repository.save(produto)
    }

    fun deleteProduto(@PathVariable id : Long){
        val produto : Produto = this.searchProduto(id)
        repository.delete(produto)
    }
}