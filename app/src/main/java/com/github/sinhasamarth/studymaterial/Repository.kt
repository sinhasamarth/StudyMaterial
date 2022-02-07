package com.github.sinhasamarth.studymaterial

import com.github.sinhasamarth.studymaterial.api.RetrofitInstance

object Repository {
    suspend fun getAllData() =
        RetrofitInstance.retrofit.getData()
}