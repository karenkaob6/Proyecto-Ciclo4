package com.example.poibogota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var pointsinterest:List<PointsInterest> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson=Gson()
        val json=loadData("pointsInterestJson.json")
        val response=gson.fromJson(json,Response::class.java)
        pointsinterest= response.pointsinterest!!
        /**pointsinterest[0].pointsInterestName*/

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