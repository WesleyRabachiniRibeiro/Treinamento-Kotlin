package com.treinamento.user.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name="TB_ENDERECO")
data class Endereco(

    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long,

    @Column(name = "ds_endereco")
    val rua : String,

    @Column(name = "nr_endereco")
    val numero : Int,

    @Column(name = "ds_cidade")
    val cidade : String,

    @Column(name = "ds_estado")
    val estado : String,

    @ManyToMany(mappedBy = "enderecos")
    val usuario : List<Usuario>
)