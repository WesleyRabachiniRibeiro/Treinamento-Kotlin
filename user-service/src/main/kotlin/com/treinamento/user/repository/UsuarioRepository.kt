package com.treinamento.user.repository

import com.treinamento.user.entity.Usuario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long>{

    override fun findAll(pageable : Pageable) : Page<Usuario>

}