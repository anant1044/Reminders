package com.anantjava.reminders.personal

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.anantjava.reminders.ItemAdapter
import com.anantjava.reminders.R
import com.anantjava.reminders.Reminders
import com.anantjava.reminders.databinding.FragmentPersonalBinding

class PersonalFragment: Fragment() {

    private lateinit var binding: FragmentPersonalBinding
    val prefs: SharedPreferences by lazy {requireActivity().getSharedPreferences("Reminders", Context.MODE_PRIVATE)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.recyclerviewPersonal

        val reminders = arrayOf(
            Reminders("Phone Password", prefs.getString("Phone Password", "").toString(), R.drawable.phone_icon),
            Reminders("UPI Pin", prefs.getString("UPI Pin", "").toString(), R.drawable.upi_icon),
            Reminders("Bike Lock",prefs.getString("Bike Lock", "").toString(), R.drawable.bike_icon),
            Reminders("Metro Card", prefs.getString("Metro Card", "").toString(),R.drawable.metro_card )
        )

        val adapter = ItemAdapter(reminders)
        recyclerview.adapter = adapter



    }


}