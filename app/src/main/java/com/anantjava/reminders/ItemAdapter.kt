package com.anantjava.reminders

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable
import androidx.core.content.edit
import com.anantjava.reminders.family.FamilyFragment


class ItemAdapter(var reminders: Array<Reminders>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()  {



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



    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {

        val prefs = holder.itemView.context
            .getSharedPreferences("Reminders", Context.MODE_PRIVATE)
            holder.bind(reminders[position])

            holder.itemView.setOnClickListener {
                val dialogView = LayoutInflater.from(holder.itemView.context)
                    .inflate(R.layout.dialog_layout, null)

                val editText = dialogView.findViewById<EditText>(R.id.edit_text_input)

                AlertDialog.Builder(holder.itemView.context)
                    .setTitle("Set Value of Your ${reminders[position].title}")
                    .setView(dialogView)
                    .setPositiveButton("OK") { _, _ ->
                        prefs.edit {
                            putString(reminders[position].title, editText.text.toString())
                        }
                        holder.info.text = editText.text.toString()
                        reminders[position] = reminders[position].copy(info = editText.text.toString())
                    }
                    .setNegativeButton("Clear") { dialog, _ ->
                        prefs.edit {
                            remove(reminders[position].title)
                        }
                        dialog.dismiss()
                    }
                    .show()
            }
        }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageview: ImageView = itemView.findViewById(R.id.item_image_cardview)
        var heading: TextView = itemView.findViewById(R.id.item_heading_cardview)
        var info: TextView = itemView.findViewById(R.id.item_info_cardview)

        fun bind(reminders: Reminders) {

            imageview.setImageResource(reminders.image)
            heading.text = reminders.title
            info.text = reminders.info

        }
    }

    data class InfoSerialize(
        val info: String,
        val filename: String
    ): Serializable

}

