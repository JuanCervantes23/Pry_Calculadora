package com.example.pry_calcularimc.Model

class clsIMCModelo {

    // Calcula el IMC: Peso entre la estatura al cuadrado
    fun calcularIMC(peso: Double, estatura: Double): Double {
        return peso / (estatura * estatura)
    }

    // Determina el estado de salud basado en tu libreta
    fun determinarEstado(imc: Double): String {
        return if (imc < 18.5) {
            "Bajo Peso"
        } else if (imc < 25) {
            "Peso Normal"
        } else if (imc < 30) {
            "Obeso"
        } else {
            "Obeso I"
        }
    }
}