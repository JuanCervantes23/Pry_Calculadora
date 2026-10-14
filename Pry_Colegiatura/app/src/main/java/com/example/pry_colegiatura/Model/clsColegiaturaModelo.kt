package com.example.pry_colegiatura.Model

class clsColegiaturaModelo {

    fun calcularPromedioGlobal(p1: Double, p2: Double, p3: Double): Double {
        val promedioGlobal = (p1 + p2 + p3) / 3.0
        return promedioGlobal
    }

    fun determinarEstatus(promedioGlobal: Double): String {
        return when {
            promedioGlobal <= 7.0 -> "0"
            promedioGlobal > 7.0 && promedioGlobal <= 9.0 -> "30"
            promedioGlobal > 9.0 -> "50%"
            else -> "Error en promedio"
        }
    }

    fun calcularColegiaturaFinal(costoBase: Double, promedioGlobal: Double): Double {
        val descuento = when {
            promedioGlobal <= 7.0 -> 0.0      // 0% de descuento
            promedioGlobal > 7.0 && promedioGlobal <= 9.0 -> 0.30     // 30% de descuento
            promedioGlobal > 9.0 -> 0.50      // 50% de descuento
            else -> 0.0
        }
        val montoDescuento = costoBase * descuento
        return costoBase - montoDescuento
    }
}