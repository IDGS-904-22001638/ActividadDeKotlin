package com.example.ActividadDeKotlin.Palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R
import java.util.Locale

class PalindromoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        val inputText = findViewById<EditText>(R.id.inputText)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        checkButton.setOnClickListener {
            val text = inputText.text.toString().trim()

            if (text.isNotEmpty()) {
                if (isPalindrome(text)) {
                    val intent = Intent(this, ResultadoActivity::class.java)
                    intent.putExtra("original", text)
                    startActivity(intent)
                } else {
                    resultText.text = "No es un palíndromo."
                }
            } else {
                Toast.makeText(this, "Por favor ingresa una cadena.", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun isPalindrome(input: String): Boolean {
        val clean = input.lowercase(Locale.getDefault()).replace("\\s+".toRegex(), "")
        return clean == clean.reversed()
    }
}