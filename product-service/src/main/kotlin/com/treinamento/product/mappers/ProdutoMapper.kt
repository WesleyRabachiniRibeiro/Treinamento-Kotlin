package com.treinamento.product.mappers

import com.treinamento.product.controller.dto.PesquisaProdutoDTO
import com.treinamento.product.controller.dto.RegistroProdutoDTO
import com.treinamento.product.entity.Produto

class ProdutoMapper {
    companion object {

        fun fromDTO(request: RegistroProdutoDTO): Produto {
            return Produto(
                null,
                request.nome,
                request.quantidade,
                request.valor,
                request.descricao,
                request.isActive
            )
        }

        fun fromEntity(produto: Produto): PesquisaProdutoDTO {
            return PesquisaProdutoDTO(
                produto.id,
                produto.nome,
                produto.quantidade,
                produto.valor,
                produto.descricao,
                produto.isActive
            )
        }

    }
}