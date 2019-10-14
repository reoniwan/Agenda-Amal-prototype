package com.frozenproject.agendaamalku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.frozenproject.agendaamalku.R
import com.frozenproject.agendaamalku.main.Panti_Asuhan
import java.util.*

class ListPantisAdapter(private val listPantis: ArrayList<Panti_Asuhan>) :
    RecyclerView.Adapter<ListPantisAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_panti, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pantis = listPantis[position]

        Glide.with(holder.itemView.context)
            .load(pantis.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = pantis.name
        holder.tvAddress.text = pantis.address
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(pantis)
        }
    }

    override fun getItemCount(): Int {
        return listPantis.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAddress: TextView = itemView.findViewById(R.id.tv_item_address)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Panti_Asuhan)

    }

}

