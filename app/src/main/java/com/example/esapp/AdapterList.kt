package com.example.esapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterList(private val itemList: List<ItemList>) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val judul: TextView = itemView.findViewById(R.id.title)
        val subJudul: TextView = itemView.findViewById(R.id.sub_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.judul.text = item.judul
        holder.subJudul.text = item.subjudul
        holder.imageView.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = itemList.size
}
