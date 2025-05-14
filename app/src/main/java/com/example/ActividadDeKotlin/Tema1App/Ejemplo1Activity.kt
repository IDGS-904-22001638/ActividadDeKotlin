package com.example.ActividadDeKotlin.Tema1App

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class Ejemplo1Activity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        rb1 = findViewById<RadioButton>(R.id.rb1)
        rb2 = findViewById<RadioButton>(R.id.rb2)
        rb3 = findViewById<RadioButton>(R.id.rb3)
        rb4 = findViewById<RadioButton>(R.id.rb4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View) {
        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()
        var resultado = 0.0
        if (rb1.isChecked) {
            resultado = num1 + num2
        } else if (rb2.isChecked) {
            resultado = num1 - num2
        } else if (rb3.isChecked) {
            resultado = num1 * num2
        } else if (rb4.isChecked) {
            resultado = num1 / num2
        }
        tv1.text = resultado.toString()
    }
}
