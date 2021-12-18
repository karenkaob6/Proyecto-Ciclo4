package com.example.poibogota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.widget.Button
import com.example.poibogota.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.temporal.TemporalQuery


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var pointsinterest:List<PointsInterest> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson=Gson()
        //val json=loadData("pointsInterestJson.json")
        loadWebData()
        //val json=loadWebData()
        //val response=gson.fromJson(json,Response::class.java)
        val boton1=findViewById<Button>(R.id.configBtn)
        boton1.setOnClickListener {
            val intento1 = Intent(this, Preferencias::class.java)
            startActivity(intento1)
        }

    }


    fun initRecycler(){
        rvPoints.layoutManager=LinearLayoutManager(this)
        val adapter=PointsAdapter(pointsinterest)
        rvPoints.adapter=adapter


    }
    fun loadData(inFile:String):String{
        var tContents=""
        try{
            val stream =assets.open(inFile)
            val size=stream.available()
            val buffer= ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContents=String(buffer)
        }
        catch (e:IOException){

        }
        return tContents
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/Orloxx23/POI/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun loadWebData(): List<PointsInterest> {
        var response:List<PointsInterest> = listOf()
        var tContents=""
        doAsync {
            val call = getRetrofit().create(APIService::class.java).getPoints().execute()
            val points = call.body() as Response
            uiThread{
                if(call.isSuccessful){
                    response = points.pointsinterest
                    pointsinterest = response
                    initRecycler()

                } else {
                    println("No funciona :c")
                    println(call.errorBody())
                    println(call.code())

                }
            }
        }
        return response
    }
}
