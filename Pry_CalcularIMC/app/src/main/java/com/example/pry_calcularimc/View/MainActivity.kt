package com.example.pry_calcularimc.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.pry_calcularimc.R
import com.example.pry_imc.Presenter.clsIMCPresenter
import com.example.pry_calcularimc.View.IIMCView

class MainActivity : AppCompatActivity(), IIMCView {

    private lateinit var presenter: clsIMCPresenter

    // Cajas de entrada
    private lateinit var txtPaciente: EditText
    private lateinit var txtPeso: EditText
    private lateinit var txtEstatura: EditText

    // Textos de salida
    private lateinit var txtNombre: TextView
    private lateinit var txtIMC: TextView
    private lateinit var txtEstadoSalud: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = clsIMCPresenter(this)

        // Enlazamos los IDs del diseño
        txtPaciente = findViewById(R.id.txtPaciente)
        txtPeso = findViewById(R.id.txtPeso)
        txtEstatura = findViewById(R.id.txtEstatura)

        txtNombre = findViewById(R.id.txtNombre)
        txtIMC = findViewById(R.id.txtIMC)
        txtEstadoSalud = findViewById(R.id.txtEstadoSalud)

        val btnCalcularIMC = findViewById<Button>(R.id.btnCalcularIMC)

        // Evento del botón
        btnCalcularIMC.setOnClickListener {
            val nombre = txtPaciente.text.toString()
            val peso = txtPeso.text.toString()
            val estatura = txtEstatura.text.toString()

            if (nombre.isNotEmpty() && peso.isNotEmpty() && estatura.isNotEmpty()) {
                presenter.procesarDatos(nombre, peso, estatura)
            } else {
                mostrarError("Llena todos los campos")
            }
        }
    }

    override fun mostrarNombre(nombre: String) {
        txtNombre.text = nombre
    }

    override fun mostrarIMC(imc: String) {
        txtIMC.text = imc
    }

    override fun mostrarEstado(estado: String) {
        txtEstadoSalud.text = estado
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}