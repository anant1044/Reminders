package com.anantjava.reminders

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class ItemAdapter(var reminders: Array<Reminders>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun getItemCount(): Int {
        return reminders.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ItemViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reminders, parent, false)
        return ItemViewHolder(view)

    }


    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val prefs = holder.itemView.context
            .getSharedPreferences("Reminders", Context.MODE_PRIVATE)
        holder.bind(reminders[position])

        holder.itemView.setOnClickListener {
            val dialogView = LayoutInflater.from(holder.itemView.context)
                .inflate(R.layout.dialog_layout, null)

            val editText = dialogView.findViewById<EditText>(R.id.edit_text_input)
            editText.setText(prefs.getString("${reminders[position].title}", ""))

            MaterialAlertDialogBuilder(holder.itemView.context)
                .setView(dialogView)
                .setPositiveButton("OK") { _, _ ->
                    prefs.edit {
                        putString(reminders[position].title, editText.text.toString())
                    }
                    holder.info.text = editText.text.toString()
                    reminders[position] = reminders[position].copy(info = editText.text.toString())
                }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .setNeutralButton("Clear") { dialog, _ ->
                    prefs.edit {
                        remove(reminders[position].title)
                    }
                    holder.info.text = ""
                    reminders[position] = reminders[position].copy(info = "")
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

}

