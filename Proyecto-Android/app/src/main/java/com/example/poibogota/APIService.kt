package com.example.poibogota

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("db")
    fun getPoints(): Call<Response>

}