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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poibogot.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pointsInterest: List<PointsInterest> = listOf(
        PointsInterest("Planetario","Carrera 6A #26-07","El Planetario de Bogotá es un escenario cultural y de divulgación científica integrado desde 2012 al Instituto Distrital de las Artes - Idartesentidad adscrita a la Secretaría de Cultura Recreación y Deporte de la Alcaldía Mayor de Bogotá.",
            "https://www.culturarecreacionydeporte.gov.co/sites/default/files/adjuntos_paginas_2014/planetario_iii.jpg","19C°"),
        PointsInterest("Museo Nacional","Carrera 7 N. 28-66 ","El Museo Nacional de Colombia fue creado en 1823, y es uno de los más antiguos de América. Ofrece a sus visitantes diecisiete salas de exposición permanente, en las cuales se exhiben alrededor de 2.500 obras y objetos, símbolos de la historia y el patrimonio nacional. ","https://www.museonacional.gov.co/elementosDifusion/2016/noticias/CumpleMuseo.jpg","20C°"),
        PointsInterest("Monserrate","Carrera 2da #21-48","El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad. Monserrate tiene una altitud de 3152 m y se ubica sobre la cordillera oriental.",
            "https://dam.tbg.com.mx/content/dam/tbg/mexico/natgeo/mx/traveler/lugares/17/10/12/santuario-de-monserrate-bogota.jpg.imgo.jpg","15C°"
        )  ,    PointsInterest("Plazoleta del Chorro de Quevedo","calle 12B carrera 2","La plazoleta del Chorro de Quevedo es un lugar público de Bogotá. En este lugar estableció su guarnición militar Gonzalo Jiménez de Quesada, antes de fundar la ciudad en este mismo lugar en 1538. Se encuentra enmarcada por construcciones coloniales y de principios del siglo XX.",
        "https://lonelyplanetimages.imgix.net/a/g/hi/t/e593a4688ed33ad7330e1e27010a8508-plazoleta-del-chorro-de-quevedo.jpg","18C°")

    )

    private lateinit var appBarConfiguration: AppBarConfiguration
   // private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pointsInterest[0].namePointsInterest

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)

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