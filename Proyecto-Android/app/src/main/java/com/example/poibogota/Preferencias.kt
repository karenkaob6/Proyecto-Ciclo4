package com.example.poibogota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Preferencias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)
        val atras =findViewById<Button>(R.id.backBtn)
        atras.setOnClickListener{
            finish()
        }
    }
}