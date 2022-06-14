package com.treinamento.user.exceptions

class AgeException(val age : Int) : IllegalArgumentException("Invalid age: $age, User is not old enought. User is too long")