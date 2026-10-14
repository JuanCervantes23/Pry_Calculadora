package com.example.pry_appcfe.Presentador

import com.example.Pry_AppCFE.Modelo.clsCFEModelo
import com.example.Pry_AppCFE.Vista.MainActivity

class clsCFEPresentador(val vista: MainActivity) {
    val modelo = clsCFEModelo()

    fun CalcularKwConsumidos(txtLecturaAnterior: String, txtLecturaActual: String) {
        val lecturaAnterior = txtLecturaAnterior.toDoubleOrNull() ?: 0.0
        val lecturaActual = txtLecturaActual.toDoubleOrNull() ?: 0.0
        val kwConsumidos = modelo.CalcularKwConsumidos(lecturaAnterior, lecturaActual)

        // Colocar datos de salida en la vista
        vista.mostrarKWConsumidos(kwConsumidos)
    }

    fun CalcularRecibo(kwConsumidos: Double, txtCostoKw: String) {
        val costoKw = txtCostoKw.toDoubleOrNull() ?: 0.0
        val recibo = modelo.CalcularRecibo(kwConsumidos, costoKw)

        // Colocar datos de salida en la vista
        vista.mostrarReciboPago(recibo.toString())
    }
}