package com.example.ActividadDeKotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnEjemplo2 = findViewById<Button>(R.id.btn2)

        btnEjemplo1.setOnClickListener {
            navegateToEjemplo1()
        }

        btnEjemplo2.setOnClickListener {
            navegateToEjemplo2()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToEjemplo1(){
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjemplo2(){
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }
}