package com.example.pry_calculadora.Model

class clsCalculadoraModelo {
    fun sumar(num1: Int, num2: Int): Int {
        return num1 + num2
    }
    fun restar(num1: Int, num2: Int): Int {
        return num1 - num2
    }
    fun multiplicar(num1: Int, num2: Int): Int {
        return num1 * num2
    }
    fun dividir(num1: Int, num2: Int): Int {
        if (num2 == 0) {
            return 0
        }
        return num1 / num2
    }
}