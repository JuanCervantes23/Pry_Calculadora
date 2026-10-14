package com.example.pry_colegiatura.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.pry_colegiatura.R
import com.example.pry_colegiatura.Presenter.clsColegiaturaPresenter

class MainActivity : AppCompatActivity(), IColegiaturaView {
    private lateinit var presenter: clsColegiaturaPresenter

    private lateinit var txtMatricula: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtPromedio1: EditText
    private lateinit var txtPromedio2: EditText
    private lateinit var txtPromedio3: EditText
    private lateinit var txtCosto: EditText

    // Declaración de los textos de salida (resultados)
    private lateinit var txtResAlumno: TextView
    private lateinit var txtResPromedio: TextView
    private lateinit var txtResActual: TextView
    private lateinit var txtResFinal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inicializar el presentador
        presenter = clsColegiaturaPresenter(this)

        // 2. Enlazar las vistas de entrada (IDs del diseño)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtNombre = findViewById(R.id.txtNombre)
        txtPromedio1 = findViewById(R.id.txtPromedio1)
        txtPromedio2 = findViewById(R.id.txtPromedio2)
        txtPromedio3 = findViewById(R.id.txtPromedio3)
        txtCosto = findViewById(R.id.txtCosto)

        // 3. Enlazar las vistas de salida
        txtResAlumno = findViewById(R.id.txtResAlumno)
        txtResPromedio = findViewById(R.id.txtResPromedio)
        txtResActual = findViewById(R.id.txtResActual)
        txtResFinal = findViewById(R.id.txtResFinal)

        // 4. Enlazar los botones
        val btnPromedio = findViewById<Button>(R.id.btnPromedio)
        val btnEstatus = findViewById<Button>(R.id.btnEstatus)
        val btnColegiatura = findViewById<Button>(R.id.btnColegiatura)

        btnPromedio.setOnClickListener(this::procesarPromedio)

        btnEstatus.setOnClickListener (this::procesarEstatus)

        btnColegiatura.setOnClickListener (this::procesarColegiatura)


    }

    fun procesarPromedio(v: View ){
       presenter.procesarPromedio(txtPromedio1.text.toString(),
        txtPromedio2.text.toString(),
        txtPromedio3.text.toString())
    }

    fun procesarEstatus(v: View){
        presenter.procesarEstatus(promedioGlobal = txtResPromedio.text.toString())

    }

    fun procesarColegiatura(v: View){
        presenter.procesarColegiatura(
        txtMatricula.text.toString(),
        txtNombre.text.toString(),
        txtCosto.text.toString(),
            txtResPromedio.text.toString())
    }

    override fun mostrarPromedio(promedio: String) {
        txtResPromedio.text = promedio
    }

    override fun mostrarEstatus(estatus: String) {
        // Creamos una ventana emergente en el centro de la pantalla
        val alerta = androidx.appcompat.app.AlertDialog.Builder(this)
        alerta.setTitle("Estatus del Alumno")
        alerta.setMessage(estatus)
        alerta.setPositiveButton("Aceptar", null)
        alerta.show()
    }

    override fun mostrarDatosAlumno(datos: String, colegiaturaActual: String) {
        txtResAlumno.text = datos
        txtResActual.text = colegiaturaActual
    }

    override fun mostrarColegiaturaFinal(total: String) {
        txtResFinal.text = total
    }

    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}