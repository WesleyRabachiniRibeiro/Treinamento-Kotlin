package com.treinamento.user.service

import com.treinamento.user.entity.Usuario
import com.treinamento.user.exceptions.AgeException
import com.treinamento.user.exceptions.StatusException
import com.treinamento.user.repository.UsuarioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun saveUsuario(usuario: Usuario) : Usuario{
        if (usuario.idade < 18) {
            throw AgeException(usuario.idade)
        }
        return repository.save(usuario)
    }

    fun disableUser(id : Long) : Usuario{
        val usuario = searchUsuario(id)
        if (usuario.isActive == false){
            throw StatusException(usuario.isActive)
        }
        usuario.isActive = false
        return repository.save(usuario)
    }

    fun ableUser(id : Long) : Usuario{
        val usuario = searchUsuario(id)
        if (usuario.isActive == true){
            throw StatusException(usuario.isActive)
        }
        usuario.isActive = true
        return repository.save(usuario)
    }

    fun searchUsuario(id: Long) : Usuario{
        val usuario : Optional<Usuario> = repository.findById(id)
        return  usuario.orElseThrow()
    }

    fun listAllUsuarios(pageable: Pageable) : Page<Usuario>{
        return repository.findAll(pageable)
    }

    fun updateUsuario(usuario: Usuario, id : Long) : Usuario{
        val initialUsuario : Usuario = this.searchUsuario(id)
        usuario.id = initialUsuario.id
        return repository.save(usuario)
    }

    fun deleteUsuario(@PathVariable id : Long){
        val usuario : Usuario = this.searchUsuario(id)
        repository.delete(usuario)
    }
}