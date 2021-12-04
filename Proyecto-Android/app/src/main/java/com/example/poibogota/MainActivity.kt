package com.example.poibogota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.widget.Button
import com.example.poibogota.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var pointsinterest:List<PointsInterest> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson=Gson()
        val json=loadData("pointsInterestJson.json")
        val response=gson.fromJson(json,Response::class.java)
        pointsinterest= response.pointsinterest!!
        initRecycler()

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
}