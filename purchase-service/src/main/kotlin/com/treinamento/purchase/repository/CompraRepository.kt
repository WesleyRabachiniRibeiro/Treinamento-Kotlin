package com.treinamento.purchase.repository

import com.treinamento.purchase.entity.Compra
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

interface CompraRepository : MongoRepository<Compra, String> {
}