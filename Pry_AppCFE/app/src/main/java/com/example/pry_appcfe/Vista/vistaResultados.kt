package com.example.Pry_AppCFE.Vista

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_appcfe.R

class vistaResultados : AppCompatActivity() {
    private lateinit var txtKwConsumidos: TextView
    private lateinit var txtRecibo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_resultados)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtKwConsumidos = findViewById(R.id.vista2txtTotalKw)
        txtRecibo = findViewById(R.id.vista2txtPagoRecibo)

        // 1. Recuperar los datos enviados de la vista 1
        val kw = intent.getStringExtra("EXTRA_KWCONSUMIDOS") ?: ""
        val total = intent.getStringExtra("EXTRA_RECIBO") ?: ""

        // 2. Mostrar los resultados en la interfaz vista 2
        txtKwConsumidos.text = "KW Consumidos: $kw"
        txtRecibo.text = "Total a Pagar: $$total"
    }
}