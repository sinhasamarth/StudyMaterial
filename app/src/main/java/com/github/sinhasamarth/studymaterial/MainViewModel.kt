package com.github.sinhasamarth.studymaterial

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.studymaterial.model.Data
import com.github.sinhasamarth.studymaterial.model.ResponseModel
import com.github.sinhasamarth.studymaterial.model.ResponseModelItem
import com.github.sinhasamarth.studymaterial.model.ResponseView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

object MainViewModel : ViewModel() {

    val ApiResponse = MutableLiveData<ResponseModel>()
    val ApiView = MutableLiveData<ArrayList<ResponseView>>()
    val Stackdata = Stack<List<Data>>()

    fun getAllData() {
        GlobalScope.launch(Dispatchers.IO) {
            val cache = Repository.getAllData()
            withContext(Dispatchers.Main) {
                ApiResponse.value = cache
                jsonObjectTraversal()
            }
        }

    }

    fun jsonObjectTraversal() {
        val data = ArrayList<ResponseView>()
        for (r in ApiResponse.value!!) {
            data.add(
                ResponseView(
                    title = r.key,
                    desc = "NA",
//                    ImageIcon = r.meta.icon.toString()
                )
            )
        }
        ApiView.value = data
    }

    fun onClickView(position: Int) {
        Log.d("CLICKED ON ", position.toString())
        if (ApiResponse.value != null) {
            val s = ApiResponse.value!![position].data
            Stackdata.push(s)
            setData()
            Log.d("CLICKED ON ", ApiView.value.toString())
        }
        else{

        }
    }

    fun setData() {
        val data = ArrayList<ResponseView>()
        for (r in Stackdata.peek()) {
            data.add(
                ResponseView(
                    title = r.key,
                    desc = "NA",
//                    ImageIcon = r.meta.icon.toString()
                )
            )
        }
        ApiView.value = data
    }

    fun removeStackData(): Boolean {
        if (!Stackdata.isEmpty()) {
            Stackdata.pop()
            if (!Stackdata.isEmpty())
            setData()
            return true;
        }
        return false;
    }


}
