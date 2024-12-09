package com.example.myapplication

object UserData {
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var birthdate: String? = null

    // Método opcional para limpiar los datos
    fun clear() {
        name = null
        email = null
        password = null
        birthdate = null
    }
}
