package com.github.sinhasamarth.studymaterial.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.sinhasamarth.studymaterial.R
import com.github.sinhasamarth.studymaterial.listerns.onClickView
import com.github.sinhasamarth.studymaterial.model.ResponseModelItem
import com.github.sinhasamarth.studymaterial.model.ResponseView

class HomeRecylerView(
    val data: List<ResponseModelItem>,
    val position: Int = 0,
    val listeners: onClickView
) :
    RecyclerView.Adapter<HomeRecylerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.left_icon)
        val nextBtn: ImageButton = itemView.findViewById(R.id.nextButoon)


        fun setView(responseView: ResponseModelItem) {
            title.text = responseView.key.uppercase()
        }

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
        holder.setView(data[position])
        holder.title.text = data[position].key.uppercase()

        holder.nextBtn.setOnClickListener {
            listeners.onClick(position)
        }
    }

    override fun getItemCount() = data.size
}