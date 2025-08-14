package com.anantjava.reminders.work

import android.content.Context
import android.content.SharedPreferences
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
    val prefs: SharedPreferences by lazy {requireActivity().getSharedPreferences("Reminders", Context.MODE_PRIVATE)}
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
            Reminders("Roll NO.", prefs.getString("Roll NO.", "").toString() , R.drawable.roll_student ),
            Reminders("Student ID",prefs.getString("Student ID", "").toString() , R.drawable.student_ic),

        )

        val adapter = ItemAdapter(reminders)
        recyclerview.adapter = adapter
    }

    }

