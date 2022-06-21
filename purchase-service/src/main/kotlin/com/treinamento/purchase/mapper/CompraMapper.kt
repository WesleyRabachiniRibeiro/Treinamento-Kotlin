package com.treinamento.purchase.mapper

import com.treinamento.purchase.DTO.PesquisarCompraDTO
import com.treinamento.purchase.DTO.RegistrarCompraDTO
import com.treinamento.purchase.entity.Compra
import java.math.BigDecimal

class CompraMapper{
    companion object {

        fun fromDTO(request: RegistrarCompraDTO): Compra {
            return Compra(
                null,
                request.usuario,
                request.produto,
                request.qtdComprado,
                BigDecimal.ZERO,
                BigDecimal.ZERO
            )
        }

        fun fromEntity(compra: Compra): PesquisarCompraDTO {
            return PesquisarCompraDTO(
                compra.id,
                compra.usuario,
                compra.produto,
                compra.qtdComprado,
                compra.valor,
                compra.valorTotal
            )
        }
    }
}