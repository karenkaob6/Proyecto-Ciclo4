package com.example.poibogota

import android.app.Activity
import android.content.Intent
import com.squareup.picasso.Picasso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.poibogota.databinding.ActivityDetalleBinding
import com.example.poibogota.databinding.ActivityMainBinding

class Detalle : AppCompatActivity() {
    lateinit var tvDescriptionDetalle:TextView
    lateinit var ivImageDetalle:ImageView
    lateinit var tvNameDetalle:TextView
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_detalle)

        val name=  intent.getStringExtra("name")
        val description=  intent.getStringExtra("description")
        val imagen=  intent.getStringExtra("imagen")
        tvNameDetalle= findViewById(R.id.tvName)
        tvDescriptionDetalle = findViewById(R.id.tvDescription)
        ivImageDetalle= findViewById(R.id.ivImage)

        tvNameDetalle.setText(name)
        tvDescriptionDetalle.setText(description)
        Picasso.get().load(imagen).into(ivImageDetalle)

    }
}