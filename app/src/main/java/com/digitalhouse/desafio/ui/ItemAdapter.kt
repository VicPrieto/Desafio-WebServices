package com.digitalhouse.desafio.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.desafio.R
import com.digitalhouse.desafio.models.HQ
import com.squareup.picasso.Picasso

class ItemAdapter(val listaHQ: HQ, val listener: OnComicClickListener) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val ivThumbnail: ImageView = itemView.findViewById(R.id.iv_thumbnail)
        val tvId: TextView = itemView.findViewById(R.id.tv_id)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (RecyclerView.NO_POSITION != position) {
                listener.comicClick(position)
            }
        }
    }

    interface OnComicClickListener {
        fun comicClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val hq = listaHQ.data.results[position]
        val thumbURL = "${hq.thumbnail.path}.${hq.thumbnail.extension}"
        holder.tvId.text = hq.id.toString()

        Picasso.get().load(thumbURL).fit().centerCrop().into(holder.ivThumbnail)
    }

    override fun getItemCount() = listaHQ.data.results.size

}