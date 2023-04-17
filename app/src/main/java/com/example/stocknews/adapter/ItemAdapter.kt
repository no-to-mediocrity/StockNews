package com.example.stocknews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stocknews.R
import com.example.stocknews.module.News
import com.squareup.picasso.Picasso

class ItemAdapter(
    private val dataset: List<News>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
         val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val news = dataset[position]
        holder.titleView.text = news.title
          if (news.image != "") {
            Picasso.get().load(news.image).fit().into(holder.imageView)
        }
    }

    override fun getItemCount() = dataset.size
}

