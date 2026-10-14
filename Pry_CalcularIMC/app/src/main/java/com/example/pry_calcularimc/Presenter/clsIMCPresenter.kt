package com.example.pry_imc.Presenter

import com.example.pry_calcularimc.Model.clsIMCModelo
import com.example.pry_calcularimc.View.IIMCView

class clsIMCPresenter(private val vista: IIMCView) {

    private val modelo = clsIMCModelo()

    fun procesarDatos(nombre: String, pesoTxt: String, estaturaTxt: String) {
        try {
            // Convertimos el texto a decimales (Double)
            val peso = pesoTxt.toDouble()
            val estatura = estaturaTxt.toDouble()

            // Llamamos al modelo para calcular
            val imc = modelo.calcularIMC(peso, estatura)
            val estado = modelo.determinarEstado(imc)

            // Le decimos a la vista que muestre los resultados
            vista.mostrarNombre("Paciente: $nombre")

            // Formateamos el IMC para que solo tenga 2 decimales
            vista.mostrarIMC("IMC: ${String.format("%.2f", imc)}")
            vista.mostrarEstado("Estado: $estado")

        } catch (e: Exception) {
            vista.mostrarError("Por favor ingresa números válidos")
        }
    }
}