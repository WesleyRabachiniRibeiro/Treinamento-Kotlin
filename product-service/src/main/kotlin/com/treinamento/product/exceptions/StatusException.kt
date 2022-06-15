package com.treinamento.user.exceptions

class StatusException(status : Boolean) : IllegalArgumentException(buildString {
        val st : String = when(status){
            true -> "active"
            false -> "disabled"
        }
        append("Usuario is already ")
        append(st)
    }
)