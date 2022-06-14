package com.treinamento.user.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name="TB_USUARIO")
data class Usuario(

        @Id
        @Column(name = "cd_usuario")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "nm_usuario")
        val nome: String,

        @Column(name = "nr_idade")
        val idade: Int,

        @ManyToMany
        @JoinTable(name = "TB_USUARIO_ENDERECO",
                joinColumns = arrayOf(JoinColumn(name = "cd_usuario")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "cd_endereco")))
        var enderecos: List<Endereco>?,

        @Column(name = "nr_telefone")
        val telefone: String,

        @Column(name = "ds_email")
        val email: String,

        @Column(name = "ds_senha")
        val senha: String,

        @Column(name = "st_usuario")
        var isActive: Boolean = true,
)