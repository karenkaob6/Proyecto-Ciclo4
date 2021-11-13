package com.example.poibogot
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poibogot.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pointsInterest: List<PointsInterest> = listOf(
        PointsInterest("Planetario","Carrera 6A #26-07","https://www.culturarecreacionydeporte.gov.co/sites/default/files/adjuntos_paginas_2014/planetario_iii.jpg"),
        PointsInterest("Museo Nacional","Carrera 7 N. 28-66 ","https://www.museonacional.gov.co/elementosDifusion/2016/noticias/CumpleMuseo.jpg"),
        PointsInterest("Monserrate","Carrera 2da #21-48","https://dam.tbg.com.mx/content/dam/tbg/mexico/natgeo/mx/traveler/lugares/17/10/12/santuario-de-monserrate-bogota.jpg.imgo.jpg")
    )

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pointsInterest[0].namePointsInterest

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        initRecycler()



    }
    fun initRecycler(){
        rvPointsInterest.layoutManager= LinearLayoutManager(this )
        val adapter = PointsAdapter(pointsInterest)
        rvPointsInterest.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}