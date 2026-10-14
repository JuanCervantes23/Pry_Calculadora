package com.example.pry_colegiatura.Presenter

import com.example.pry_colegiatura.Model.clsColegiaturaModelo
import com.example.pry_colegiatura.View.IColegiaturaView

class clsColegiaturaPresenter(private val vista: IColegiaturaView) {

    private val modelo = clsColegiaturaModelo()

    fun procesarPromedio(p1: String, p2: String, p3: String) {
        try {
            val promedio = modelo.calcularPromedioGlobal(p1.toDouble(), p2.toDouble(), p3.toDouble())
            vista.mostrarPromedio("Promedio Global: ${String.format("%.2f", promedio)}")
        } catch (e: Exception) {
            vista.mostrarError("Faltan calificaciones")
        }
    }

    fun procesarEstatus(promedioGlobal: Double) {
        try {
            val estatus = modelo.determinarEstatus(promedioGlobal)
            vista.mostrarEstatus(estatus)
        } catch (e: Exception) {
            vista.mostrarError("Faltan calificaciones para el estatus")
        }
    }

    fun procesarColegiatura(matricula: String, nombre: String, costo: String,promedioGlobal: Double) {
        try {
            val costoBase = costo.toDouble()
            val totalPagar = modelo.calcularColegiaturaFinal(costoBase, promedioGlobal)

            vista.mostrarDatosAlumno("$matricula - $nombre", "Colegiatura Actual: $$costoBase")
            vista.mostrarColegiaturaFinal("Colegiatura Final: $${String.format("%.2f", totalPagar)}")
        } catch (e: Exception) {
            vista.mostrarError("Verifica que todos los campos estén llenos")
        }
    }
}