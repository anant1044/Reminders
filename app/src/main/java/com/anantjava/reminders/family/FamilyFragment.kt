package com.anantjava.reminders.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anantjava.reminders.ItemAdapter
import com.anantjava.reminders.R
import com.anantjava.reminders.Reminders
import com.anantjava.reminders.databinding.FragmentFamilyBinding

class FamilyFragment: Fragment() {
    private lateinit var binding: FragmentFamilyBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.recyclerviewFamily

        val reminders = arrayOf(
            Reminders("Door Lock", "2007", R.drawable.door_lockl),
            Reminders("Wifi Password", "anant@1044",R.drawable.wifi_pass )
        )

        val adapter = ItemAdapter(reminders)
        recyclerview.adapter = adapter
    }
}