package com.github.sinhasamarth.studymaterial

import com.github.sinhasamarth.studymaterial.api.RetrofitInstance

class Repository {
    suspend fun getAllData() =
        RetrofitInstance.retrofit.getData()
}