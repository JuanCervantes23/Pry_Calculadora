package com.example.pry_appcfe_2.Modelo

class clsCFEModelo {
    fun CalcularKwConsumidos(lecturaAnterior: Double, lecturaActual: Double): Double {
        return lecturaActual - lecturaAnterior
    }

    fun CalcularRecibo(kwConsumidos: Double, costoKw: Double): Double {
        return kwConsumidos * costoKw
    }
}