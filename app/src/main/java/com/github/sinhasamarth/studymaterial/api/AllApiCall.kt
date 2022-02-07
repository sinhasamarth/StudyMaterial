package com.github.sinhasamarth.studymaterial.api

import com.github.sinhasamarth.studymaterial.model.ResponseModel
import retrofit2.http.GET

interface AllApiCall {

    @GET("/v3/a7fa4d82-5479-4945-be59-6813c921e069")
    suspend fun getData(): ResponseModel
}