package com.github.sinhasamarth.studymaterial.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AllApiCall::class.java)
}