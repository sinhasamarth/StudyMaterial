package com.github.sinhasamarth.studymaterial.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.sinhasamarth.studymaterial.R
import com.github.sinhasamarth.studymaterial.model.ResponseModel

class HomeRecylerView(val data: MutableList<ResponseModel>) :
    RecyclerView.Adapter<HomeRecylerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val image: ImageView = itemView.findViewById<ImageView>(R.id.left_icon)
        val nextBtn: ImageButton = itemView.findViewById<ImageButton>(R.id.nextButoon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_recyler_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount() = data.size
}