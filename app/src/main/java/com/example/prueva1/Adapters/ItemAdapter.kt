package com.example.prueva1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueva1.Models.Item
import com.example.prueva1.R
import kotlinx.android.synthetic.main.item_of_recycle.view.*

class ItemAdapter(private val itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_of_recycle,parent,false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem=itemList[position]
        holder.imageV.setImageResource(currentItem.imgRoute)
        holder.textTitle1.text=currentItem.titleOne
        holder.textTitle2.text=currentItem.titleTwo
    }

    override fun getItemCount()=itemList.size

    class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageV: ImageView=itemView.imageViewItem
        val textTitle1:TextView=itemView.textViewItemTitle
        val textTitle2:TextView=itemView.text_2
    }

}