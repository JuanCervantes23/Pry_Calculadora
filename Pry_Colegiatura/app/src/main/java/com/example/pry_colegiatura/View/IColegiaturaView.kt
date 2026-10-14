package com.example.pry_colegiatura.View

interface IColegiaturaView {
    fun mostrarPromedio(promedio: String)
    fun mostrarEstatus(estatus: String)
    fun mostrarColegiaturaFinal(total: String)
    fun mostrarDatosAlumno(datos: String, colegiaturaActual: String)
    fun mostrarError(mensaje: String)
}