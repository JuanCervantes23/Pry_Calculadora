package com.example.pry_calcularimc.View

interface IIMCView {
    fun mostrarNombre(nombre: String)
    fun mostrarIMC(imc: String)
    fun mostrarEstado(estado: String)
    fun mostrarError(mensaje: String)
}