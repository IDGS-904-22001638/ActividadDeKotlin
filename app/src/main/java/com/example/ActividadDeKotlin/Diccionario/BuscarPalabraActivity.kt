package com.example.ActividadDeKotlin.Diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class BuscarPalabraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabra)

        val etBuscar = findViewById<EditText>(R.id.etBuscar)
        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnBuscar.setOnClickListener {
            val palabra = etBuscar.text.toString().trim()
            if (palabra.isEmpty()) {
                Toast.makeText(this, "Ingresa una palabra", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val diccionario = openFileInput("diccionario.txt").bufferedReader().readLines()
            var encontrado = false

            for (linea in diccionario) {
                val partes = linea.split(":")
                if (partes.size == 2) {
                    if (rbEspanol.isChecked && partes[0].equals(palabra, ignoreCase = true)) {
                        tvResultado.text = "Español: ${partes[1]}"
                        encontrado = true
                        break
                    } else if (rbIngles.isChecked && partes[1].equals(palabra, ignoreCase = true)) {
                        tvResultado.text = "Inglés: ${partes[0]}"
                        encontrado = true
                        break
                    }
                }
            }

            if (!encontrado) {
                tvResultado.text = "Palabra no encontrada"
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}