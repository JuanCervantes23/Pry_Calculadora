package com.example.pry_appcfe.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_appcfe.Presentador.clsCFEPresentador
import com.example.pry_appcfe.R

class MainActivity : AppCompatActivity() {
    private lateinit var txtLecturaAnterior: EditText
    private lateinit var txtLecturaActual: EditText
    private lateinit var txtCostoKw: EditText
    private lateinit var btnCalcularKW: Button
    private lateinit var txtKwConsumidos: TextView
    private lateinit var btnCalcularRecibo: Button
    private lateinit var txtRecibo: TextView
    private lateinit var btnPasarDatos: Button

    private lateinit var presentador: clsCFEPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtLecturaAnterior = findViewById(R.id.txtLecturaAnterior)
        txtLecturaActual = findViewById(R.id.txtLecturaActual)
        txtCostoKw = findViewById(R.id.txtCostoKw)
        btnCalcularKW = findViewById(R.id.btnCalcularKw)
        txtKwConsumidos = findViewById(R.id.txtTotalKw)
        btnCalcularRecibo = findViewById(R.id.btnCalcularRecibo)
        txtRecibo = findViewById(R.id.txtPagoRecibo)
        btnPasarDatos = findViewById(R.id.btnPasarDatos)

        presentador = clsCFEPresentador(this)

        btnCalcularKW.setOnClickListener(this::ejecutarCalcularKW)
        btnCalcularRecibo.setOnClickListener(this::ejecutarCalcularRecibo)
        btnPasarDatos.setOnClickListener(this::ejecutarPasarDatos)
    }

    fun ejecutarCalcularKW(v: View) {
        presentador.CalcularKwConsumidos(
            txtLecturaAnterior.text.toString(),
            txtLecturaActual.text.toString()
        )
    }

    fun ejecutarCalcularRecibo(v: View) {
        val kw = txtKwConsumidos.text.toString().toDoubleOrNull() ?: 0.0
        presentador.CalcularRecibo(kw, txtCostoKw.text.toString())
    }

    fun mostrarKWConsumidos(kwConsumidos: Double) {
        txtKwConsumidos.text = kwConsumidos.toString()
    }

    fun mostrarReciboPago(recibo: String) {
        txtRecibo.text = recibo
    }

    fun ejecutarPasarDatos(v: View) {
        val vista2 = Intent(this, vistaResultados::class.java).apply {
            putExtra("EXTRA_KWCONSUMIDOS", txtKwConsumidos.text.toString())
            putExtra("EXTRA_RECIBO", txtRecibo.text.toString())
        }
        startActivity(vista2)
    }
}