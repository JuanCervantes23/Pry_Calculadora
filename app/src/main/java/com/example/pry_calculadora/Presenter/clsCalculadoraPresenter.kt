package com.example.pry_calculadora.Presenter

import com.example.pry_calculadora.Model.clsCalculadoraModelo
import com.example.pry_calculadora.View.MainActivity

class clsCalculadoraPresenter(private val vista: MainActivity) {
    private val modelo = clsCalculadoraModelo()

    fun Sumar(texto1: String, texto2: String) {
        val n1 = texto1.toIntOrNull() ?: 0
        val n2 = texto2.toIntOrNull() ?: 0
        val total = modelo.sumar(n1, n2)
        vista.mostrarResultado(total.toString())
    }

    fun Restar(texto1: String, texto2: String) {
        val n1 = texto1.toIntOrNull() ?: 0
        val n2 = texto2.toIntOrNull() ?: 0
        val total = modelo.restar(n1, n2)
        vista.mostrarResultado(total.toString())
    }

    fun Multiplicar(texto1: String, texto2: String) {
        val n1 = texto1.toIntOrNull() ?: 0
        val n2 = texto2.toIntOrNull() ?: 0
        val total = modelo.multiplicar(n1, n2)
        vista.mostrarResultado(total.toString())
    }

    fun Dividir(texto1: String, texto2: String) {
        val n1 = texto1.toIntOrNull() ?: 0
        val n2 = texto2.toIntOrNull() ?: 0
        val total = modelo.dividir(n1, n2)
        vista.mostrarResultado(total.toString())
    }
}