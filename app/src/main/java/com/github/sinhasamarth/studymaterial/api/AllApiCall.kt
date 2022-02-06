package com.github.sinhasamarth.studymaterial.api

import com.github.sinhasamarth.studymaterial.model.ResponseModel
import retrofit2.http.GET

interface AllApiCall {

    @GET("/v3/cdd009cf-4b52-40ce-a73b-0faca6cba485")
    suspend fun getData(): ResponseModel
}