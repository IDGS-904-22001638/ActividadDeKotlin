package com.example.ActividadDeKotlin.Cinepolis

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class cinepolisAndroid : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton
    private lateinit var btnCalcular: Button
    private lateinit var tvTotal: TextView

    private val PRECIO_BOLETO = 12000
    private val MAX_BOLETOS_POR_PERSONA = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis_android)

        etNombre = findViewById(R.id.etNombre)
        etCompradores = findViewById(R.id.etCompradores)
        etBoletos = findViewById(R.id.etBoletos)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvTotal = findViewById(R.id.tvTotal)
        btnCalcular.setOnClickListener {
            calcularTotal()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcularTotal() {
        val nombre = etNombre.text.toString()
        val compradoresStr = etCompradores.text.toString()
        val boletosStr = etBoletos.text.toString()

        if (nombre.isBlank() || compradoresStr.isBlank() || boletosStr.isBlank()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val compradores = compradoresStr.toIntOrNull()
        val boletos = boletosStr.toIntOrNull()

        if (compradores == null || boletos == null || compradores <= 0 || boletos <= 0) {
            Toast.makeText(this, "Ingresa números válidos", Toast.LENGTH_SHORT).show()
            return
        }

        val maxPermitido = compradores * MAX_BOLETOS_POR_PERSONA

        if (boletos > maxPermitido) {
            Toast.makeText(this, "Máximo permitido: $maxPermitido boletos", Toast.LENGTH_LONG).show()
            return
        }

        var total = boletos * PRECIO_BOLETO

        val descuentoCantidad = when {
            boletos > 5 -> 0.15
            boletos in 3..5 -> 0.10
            else -> 0.0
        }

        val descuento1 = total * descuentoCantidad
        total -= descuento1.toInt()

        var descuento2 = 0.0
        if (rbSi.isChecked) {
            descuento2 = total * 0.10
            total -= descuento2.toInt()
        }

        tvTotal.text = "$ ${"%,d".format(total)}"

        Toast.makeText(
            this,
            "Compra realizada por $nombre\nDescuento total: $${"%,.2f".format(descuento1 + descuento2)}",
            Toast.LENGTH_LONG
        ).show()
    }
}
