package com.github.sinhasamarth.studymaterial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.studymaterial.model.ResponseModel

class MainViewModel : ViewModel() {

    val ApiResponse = MutableLiveData<ResponseModel>()


}