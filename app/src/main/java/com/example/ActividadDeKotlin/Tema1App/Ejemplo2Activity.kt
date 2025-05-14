package com.example.ActividadDeKotlin.Tema1App

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class Ejemplo2Activity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun multiplicacionConSumas(view: android.view.View) {
        val num1 = et1.text.toString().toDoubleOrNull()
        val num2 = et2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            tv1.text = "Ingresa números válidos"
            return
        }

        if (num1 == 0.0 || num2 == 0.0) {
            tv1.text = "$num1 * $num2 = 0.0"
            return
        }

        var resultado = 0.0
        var texto = ""
        var repeticiones = if (num2 < 0) -num2 else num2
        var repeticionesInt = repeticiones.toInt()
        var contador = 1

        while (contador <= repeticionesInt) {
            resultado = resultado + num1
            texto = texto + num1
            if (contador < repeticionesInt) {
                texto = texto + " + "
            }
            contador = contador + 1
        }

        if (num2 < 0) {
            texto = "-($texto)"
            resultado = -resultado
        }

        tv1.text = "$texto = $resultado"
    }
}