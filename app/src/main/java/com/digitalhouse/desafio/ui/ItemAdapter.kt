package com.digitalhouse.desafio.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.HQ
import com.digitalhouse.desafio.services.retrofit
import java.util.ArrayList

class ItemAdapter (): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    val listHQ = ArrayList<HQ>()

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val iv_thumbnail: ImageView = itemView.findViewById(R.id.iv_thumbnail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val hq: HQ = listHQ.get(position)
        val imgUrl = hq.thumbnail
//        holder.iv_thumbnail.setImageURI() = hq.thumbnail
//        retrofit.get().load(imgUrl).fit().centerCrop().into(holder.iv_thumbnail)
    }

    override fun getItemCount() = listHQ.size

    fun addHQ(items: ArrayList<HQ>){
        listHQ.addAll(items)
        notifyDataSetChanged()
    }

    fun clear(){
        listHQ.clear()
        notifyDataSetChanged()
    }
}