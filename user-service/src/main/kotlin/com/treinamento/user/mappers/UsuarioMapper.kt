package com.treinamento.user.mappers

import com.treinamento.user.controllers.dto.PesquisaUsuarioDTO
import com.treinamento.user.controllers.dto.RegistroUsuarioDTO
import com.treinamento.user.entity.Usuario

class UsuarioMapper {

    companion object {

        fun fromDTO(request: RegistroUsuarioDTO): Usuario {
            return Usuario(
                null,
                request.nome,
                request.idade,
                null,
                request.telefone,
                request.email,
                request.senha,
                request.isActive
            )
        }

        fun fromEntity(usuario: Usuario): PesquisaUsuarioDTO {
            return PesquisaUsuarioDTO(
                usuario.id,
                usuario.nome,
                usuario.idade,
                usuario.telefone,
                usuario.email,
                usuario.senha,
                usuario.isActive
            )
        }

    }

}