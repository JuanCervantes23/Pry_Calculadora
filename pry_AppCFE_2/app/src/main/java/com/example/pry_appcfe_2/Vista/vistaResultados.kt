package com.example.pry_appcfe_2.Vista

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_appcfe_2.R

class vistaResultados : AppCompatActivity() {
    private lateinit var txtKwConsumidos: TextView
    private lateinit var txtRecibo: TextView

    companion object {
        var kwConsumidosEstatico: Double = 0.0
        var reciboPagoEstatico: Double = 0.0
    }

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

        txtKwConsumidos.text = "Kw Consumidos: $kwConsumidosEstatico"
        txtRecibo.text = "Recibo de pago: $reciboPagoEstatico"
    }
}