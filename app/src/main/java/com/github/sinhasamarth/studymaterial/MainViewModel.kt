package com.github.sinhasamarth.studymaterial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.studymaterial.model.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: Repository) : ViewModel() {

    val ApiResponse = MutableLiveData<ResponseModel>()

    fun getAllData() {
        GlobalScope.launch(Dispatchers.IO) {
            val cache = repository.getAllData()
            withContext(Dispatchers.Main) {
                ApiResponse.value = cache
            }
        }
    }


}