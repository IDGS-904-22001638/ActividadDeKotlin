package com.example.ActividadDeKotlin.Diccionario

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ActividadDeKotlin.R

class DiccionarioAndroid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario_android)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        btnAgregar.setOnClickListener {
            startActivity(Intent(this, AgregarPalabraActivity::class.java))
        }

        btnBuscar.setOnClickListener {
            startActivity(Intent(this, BuscarPalabraActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
