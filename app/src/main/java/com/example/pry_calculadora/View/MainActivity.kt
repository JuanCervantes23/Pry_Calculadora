package com.example.pry_calculadora.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pry_calculadora.R
import com.example.pry_calculadora.Presenter.clsCalculadoraPresenter

class MainActivity : AppCompatActivity() {
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnDividir: Button
    private lateinit var txtResultado: TextView

    private lateinit var presenter: clsCalculadoraPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        txtResultado = findViewById(R.id.txtResultado)

        presenter = clsCalculadoraPresenter(this)

        btnSumar.setOnClickListener { ejecutarAccionSumar() }
        btnRestar.setOnClickListener { ejecutarAccionRestar() }
        btnMultiplicar.setOnClickListener { ejecutarAccionMultiplicar() }
        btnDividir.setOnClickListener { ejecutarAccionDividir() }
    }

    private fun ejecutarAccionSumar() {
        presenter.Sumar(txtNum1.text.toString(), txtNum2.text.toString())
    }

    private fun ejecutarAccionRestar() {
        presenter.Restar(txtNum1.text.toString(), txtNum2.text.toString())
    }

    private fun ejecutarAccionMultiplicar() {
        presenter.Multiplicar(txtNum1.text.toString(), txtNum2.text.toString())
    }

    private fun ejecutarAccionDividir() {
        presenter.Dividir(txtNum1.text.toString(), txtNum2.text.toString())
    }

    fun mostrarResultado(resultado: String) {
        txtResultado.text = "Resultado: $resultado"
    }
}