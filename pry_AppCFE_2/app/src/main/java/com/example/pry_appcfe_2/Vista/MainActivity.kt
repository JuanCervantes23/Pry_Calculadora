package com.example.pry_appcfe_2.Vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_appcfe_2.Presentador.clsCFEPresentador
import com.example.pry_appcfe_2.R

class MainActivity : AppCompatActivity() {
    private lateinit var txtLecturaAnterior: EditText
    private lateinit var txtLecturaActual: EditText
    private lateinit var txtCostoKw: EditText
    private lateinit var btnCalcularRecibo: Button

    private var salidaKWConsumidos: Double = 0.0
    private var salidarecibo: Double = 0.0

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
        btnCalcularRecibo = findViewById(R.id.btnCalcularRecibo)

        presentador = clsCFEPresentador(this)

        btnCalcularRecibo.setOnClickListener(this::ejecutarCalcularRecibo)
    }

    fun ejecutarCalcularRecibo(v: View) {
        presentador.CalcularKwConsumidos(txtLecturaAnterior.text.toString(), txtLecturaActual.text.toString())
        presentador.CalcularRecibo(salidaKWConsumidos, txtCostoKw.text.toString())
        presentador.cargarvistaResultados(salidaKWConsumidos, salidarecibo)
    }

    fun SalidaKWConsumidos(kwConsumidos: Double) {
        salidaKWConsumidos = kwConsumidos
    }

    fun SalidaPAgoRecibo(recibo: Double) {
        salidarecibo = recibo
    }
}