package com.example.pry_appcfe_2.Presentador

import android.content.Intent
import com.example.pry_appcfe_2.Modelo.clsCFEModelo
import com.example.pry_appcfe_2.Vista.MainActivity
import com.example.pry_appcfe_2.Vista.vistaResultados

class clsCFEPresentador(val vista: MainActivity) {
    val modelo = clsCFEModelo()

    fun CalcularKwConsumidos(txtLecturaAnterior: String, txtLecturaActual: String) {
        val LecturaAnterior = txtLecturaAnterior.toDoubleOrNull() ?: 0.0
        val LecturaActual = txtLecturaActual.toDoubleOrNull() ?: 0.0
        val kwConsumidos = modelo.CalcularKwConsumidos(LecturaAnterior, LecturaActual)

        vista.SalidaKWConsumidos(kwConsumidos)
    }

    fun CalcularRecibo(kwConsumidos: Double, txtCostoKw: String) {
        val costoKw = txtCostoKw.toDoubleOrNull() ?: 0.0
        val recibo = modelo.CalcularRecibo(kwConsumidos, costoKw)

        vista.SalidaPAgoRecibo(recibo)
    }

    fun cargarvistaResultados(kwConsumidos: Double, recibo: Double) {
        val intent = Intent(vista, vistaResultados::class.java)
        vista.startActivity(intent)

        vistaResultados.kwConsumidosEstatico = kwConsumidos
        vistaResultados.reciboPagoEstatico = recibo
    }
}