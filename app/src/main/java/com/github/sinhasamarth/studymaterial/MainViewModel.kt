package com.github.sinhasamarth.studymaterial

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.studymaterial.model.ResponseModel
import com.github.sinhasamarth.studymaterial.model.ResponseModelItem
import com.github.sinhasamarth.studymaterial.model.ResponseView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : ViewModel() {
    val stackResponse = MutableLiveData<Stack<List<ResponseModelItem>>>()
    val apiResponse = MutableLiveData<ResponseModel>()
    lateinit var finalData: ResponseModelItem

    fun getDataFromApi(): ResponseModel? {
        if (apiResponse.value == null) {
            GlobalScope.launch(Dispatchers.IO) {
                val data = Repository.getAllData()
                withContext(Dispatchers.Main) {
                    Log.d("Hii", data.toString())
                    apiResponse.value = data
                    val intialValue = Stack<List<ResponseModelItem>>()
                    intialValue.push(data)
                    stackResponse.postValue(intialValue)
                }
            }
        }
        return apiResponse.value
    }

    fun itemListens(position: Int): Boolean {
        if (stackResponse.value?.peek()?.get(position)?.data.isNullOrEmpty()) {
            finalData = stackResponse.value?.peek()?.get(position)!!
            return false
        } else {
            val temp = stackResponse.value
            temp?.push(stackResponse.value?.peek()!![position].data)
            stackResponse.postValue(temp!!)
        }
        return true
    }

    fun setBackButton(): Boolean {
        return if (stackResponse.value.isNullOrEmpty() || stackResponse.value!!.peek() ==  apiResponse.value) {
            false
        } else {
            val temp = stackResponse.value
            temp?.pop()
            stackResponse.value = temp!!
            true
        }
    }

}
