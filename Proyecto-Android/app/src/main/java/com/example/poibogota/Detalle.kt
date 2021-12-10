package com.example.poibogota

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.poibogota.databinding.ActivityDetalleBinding
import com.example.poibogota.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.lang.Exception

class Detalle : AppCompatActivity() {
    lateinit var tvDescriptionDetalle:TextView
    lateinit var ivImageDetalle:ImageView
    lateinit var tvNameDetalle:TextView
    lateinit var mapButtonDetalle:Button
    lateinit var map:String
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_detalle)
            intent.getStringExtra("name")
            intent.getStringExtra("description")

        val name=  intent.getStringExtra("name")
        val descripcion=  intent.getStringExtra("description")
        val imagen=  intent.getStringExtra("imagen")
        val urlMap = intent.getStringExtra("map")
        
        tvNameDetalle= findViewById(R.id.tvName)
        tvDescriptionDetalle = findViewById(R.id.tvDescription)
        ivImageDetalle= findViewById(R.id.ivImage)
        mapButtonDetalle = findViewById(R.id.mapButton)

        tvNameDetalle.setText(name)
        tvDescriptionDetalle.setText(descripcion)
        Picasso.get().load(imagen).into(ivImageDetalle)
        map = urlMap.toString()

    }

    fun onAndrea(view: android.view.View) {
        val entry = findViewById<Button>(R.id.mapButton)
        entry.setOnClickListener {
            val uri = Uri.parse(map)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

}