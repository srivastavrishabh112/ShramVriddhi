package com.example.shramvriddhi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shramvriddhi.R
import com.example.shramvriddhi.model.DYK

class dykAdapter(private val context:Context,
                 private val dataset: List<DYK>
                 ):RecyclerView.Adapter<dykAdapter.DYKViewHolder>() {
    class DYKViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvdyk)
        val imageView: ImageView = view.findViewById(R.id.imgdyk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DYKViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dyk,parent,false)

        return DYKViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DYKViewHolder, position: Int) {
       val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}