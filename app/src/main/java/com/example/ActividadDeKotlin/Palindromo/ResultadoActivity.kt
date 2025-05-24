package com.example.ActividadDeKotlin.Palindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_palindromo)

        val original = intent.getStringExtra("original") ?: ""
        val reversa = original.reversed()
        val vocales = original.filter { it.lowercaseChar() in "aeiou" }
        val consonantes = original.filter { it.isLetter() && it.lowercaseChar() !in "aeiou" }

        findViewById<TextView>(R.id.originalText).text = "Cadena original: $original"
        findViewById<TextView>(R.id.reversedText).text = "Cadena al revés: $reversa"
        findViewById<TextView>(R.id.vowelsText).text = "Vocales: $vocales"
        findViewById<TextView>(R.id.consonantsText).text = "Número de consonantes: ${consonantes.length}"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}