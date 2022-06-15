package com.treinamento.user.controllers

import com.treinamento.user.controllers.dto.PesquisaUsuarioDTO
import com.treinamento.user.controllers.dto.RegistroUsuarioDTO
import com.treinamento.user.entity.Usuario
import com.treinamento.user.mappers.UsuarioMapper
import com.treinamento.user.service.UsuarioService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
@Api(value="API REST Usuários")
@CrossOrigin(origins = ["*"])
class UsuarioController(private val service: UsuarioService) {

    @PostMapping
    @ApiOperation(value="Salva novos usuários criados")
    fun saveUsuario(@RequestBody request: RegistroUsuarioDTO): ResponseEntity<PesquisaUsuarioDTO> {
        val usuario = service.saveUsuario(UsuarioMapper.fromDTO(request))
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario))
    }

    @GetMapping
    @ApiOperation(value="Retorna todos os usuários cadastrados")
    fun searchAllUsuarios(@PageableDefault pageable: Pageable) : ResponseEntity<Page<PesquisaUsuarioDTO>>{
        return ResponseEntity.ok(service.listAllUsuarios(pageable).map(UsuarioMapper::fromEntity))
    }

    @GetMapping("{id}")
    @ApiOperation(value="Retorna um usuário cadastrado")
    fun searchUsuario(@PathVariable id : Long) : ResponseEntity<PesquisaUsuarioDTO>{
        return try {
            val usuario : Usuario = service.searchUsuario(id)
            ResponseEntity.ok(UsuarioMapper.fromEntity(usuario))
        }catch (ex : RuntimeException){
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza os dados de um usuário")
    fun updateUsuario(
        @RequestBody registry: RegistroUsuarioDTO,
        @PathVariable id: Long
    ): ResponseEntity<PesquisaUsuarioDTO> {
        return try {
            val usuario: Usuario = service.updateUsuario(UsuarioMapper.fromDTO(registry), id)
            ResponseEntity.ok(UsuarioMapper.fromEntity(usuario))
        } catch (ex: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}/desactivate")
    @ApiOperation(value = "Desativa a conta de um usuário")
    fun desactiveUser(@PathVariable id: Long): ResponseEntity<PesquisaUsuarioDTO> {
        val usuario = service.disableUser(id)
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario))
    }

    @PatchMapping("/{id}/activate")
    @ApiOperation(value = "Ativa a conta de um usuário")
    fun activeUser(@PathVariable id: Long): ResponseEntity<PesquisaUsuarioDTO> {
        val usuario = service.ableUser(id)
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario))
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deleta a conta de um usuário")
    fun deleteUsuario(@PathVariable id: Long): ResponseEntity<PesquisaUsuarioDTO> {
        return try {
            service.deleteUsuario(id)
            ResponseEntity.ok().build()
        } catch (ex: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }
}