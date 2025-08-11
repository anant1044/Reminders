package com.anantjava.reminders.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anantjava.reminders.ItemAdapter
import com.anantjava.reminders.R
import com.anantjava.reminders.Reminders
import com.anantjava.reminders.databinding.FragmentPersonalBinding

class PersonalFragment: Fragment() {

    private lateinit var binding: FragmentPersonalBinding

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
            Reminders("Phone Password", "Amaterasu", R.drawable.phone_icon),
            Reminders("UPI Pin", "2008", R.drawable.upi_icon),
            Reminders("Bike Lock","1981", R.drawable.bike_icon),
            Reminders("Metro Card", "",R.drawable.metro_card )
        )

        val adapter = ItemAdapter(reminders)
        recyclerview.adapter = adapter

    }


}