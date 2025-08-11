package com.anantjava.reminders

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.anantjava.reminders.databinding.ActivityMainBinding
import com.anantjava.reminders.family.FamilyFragment
import com.anantjava.reminders.personal.PersonalFragment
import com.anantjava.reminders.work.WorkFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.navigationPanel.setOnItemSelectedListener(this)
        supportFragmentManager.commit { add(R.id.fragment_container, PersonalFragment()) }


    }


    private fun onFamilyClicked(): Boolean {
        supportFragmentManager.commit { replace(R.id.fragment_container, FamilyFragment()) }
        return true
    }

    private fun onWorkClicked(): Boolean {
        supportFragmentManager.commit { replace(R.id.fragment_container, WorkFragment()) }
        return true
    }

    private fun onPersonalClicked(): Boolean {
        supportFragmentManager.commit { replace(R.id.fragment_container, PersonalFragment()) }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {

        R.id.personal_icon -> onPersonalClicked()
        R.id.work_icon -> onWorkClicked()
        R.id.family_icon -> onFamilyClicked()
        else -> false
    }
}



