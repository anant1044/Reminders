package com.anantjava.reminders.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anantjava.reminders.ItemAdapter
import com.anantjava.reminders.R
import com.anantjava.reminders.Reminders
import com.anantjava.reminders.databinding.FragmentWorkBinding

class WorkFragment: Fragment() {
    private lateinit var binding: FragmentWorkBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = binding.recyclerviewWork

        val reminders = arrayOf(
            Reminders("Roll NO.", "", R.drawable.roll_student ),
            Reminders("Student ID", "", R.drawable.student_ic),

        )

        val adapter = ItemAdapter(reminders)
        recyclerview.adapter = adapter
    }

    }

