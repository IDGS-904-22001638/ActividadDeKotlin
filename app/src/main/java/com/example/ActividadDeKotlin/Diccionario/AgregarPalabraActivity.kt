package com.example.ActividadDeKotlin.Diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R
import java.io.OutputStreamWriter

class AgregarPalabraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_palabra)

        val etIngles = findViewById<EditText>(R.id.etIngles)
        val etEspanol = findViewById<EditText>(R.id.etEspanol)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnGuardar.setOnClickListener {
            val ingles = etIngles.text.toString().trim()
            val espanol = etEspanol.text.toString().trim()

            if (ingles.isNotEmpty() && espanol.isNotEmpty()) {
                val outputStream = OutputStreamWriter(openFileOutput("diccionario.txt", MODE_APPEND))
                outputStream.write("$ingles:$espanol\n")
                outputStream.close()
                Toast.makeText(this, "Palabra almacenada", Toast.LENGTH_SHORT).show()
                etIngles.text.clear()
                etEspanol.text.clear()
            } else {
                Toast.makeText(this, "Llena ambos campos", Toast.LENGTH_SHORT).show()
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
