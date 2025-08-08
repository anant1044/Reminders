package com.anantjava.reminders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(var reminders: Array<Reminders>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun getItemCount(): Int {
        return reminders.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemAdapter.ItemViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_reminders, parent, false)
        return ItemViewHolder(view)
    }



    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {

        holder.bind(reminders[position])
    }



    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageview: ImageView = itemView.findViewById(R.id.item_image_cardview)
        var heading: TextView = itemView.findViewById(R.id.item_heading_cardview)
        var info: TextView = itemView.findViewById(R.id.item_info_cardview)

        fun bind(reminders: Reminders) {

            imageview.setImageResource(reminders.image)
            heading.setText(reminders.title)
            info.setText(reminders.info)

        }
    }
}