package com.example.motivationcards.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motivationcards.R
import com.example.motivationcards.module.Affirmation

//class ItemAdapter(private val context : Context,
//        private val dataSet : List<Affirmation>
//        ) {
//    class ItemViewHolder(private val view : View)
//        : RecyclerView.ViewHolder(view){
//        val textView : TextView = view.findViewById(R.id.item_title)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return ItemViewHolder(adapterLayout)
//    }
//
//    override fun getItemCount() = dataSet.size
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val item = dataSet[position]
//        holder.textView.text = context.resources.getString(item.stringResourceId)
//    }
//}

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val ImageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.ImageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}