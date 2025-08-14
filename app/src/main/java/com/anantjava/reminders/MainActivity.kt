package com.anantjava.reminders

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anantjava.reminders.databinding.ActivityMainBinding
import com.anantjava.reminders.family.FamilyFragment
import com.anantjava.reminders.personal.PersonalFragment
import com.anantjava.reminders.work.WorkFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(){

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

        binding.fragmentContainer.adapter = ScreenSlidePagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.fragmentContainer) { tab, position ->
          when(position){
              0 -> {tab.text = "Personal" ; tab.icon = AppCompatResources.getDrawable(this, R.drawable.icons8_personal)}
              1 -> {tab.text = "Work"; tab.icon = AppCompatResources.getDrawable(this,R.drawable.icons8_work)}
              else -> {tab.text = "Family"; tab.icon = AppCompatResources.getDrawable(this,R.drawable.icons8_family)}
          }
        }.attach()
    }



    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> PersonalFragment()
            1 -> WorkFragment()
            else -> FamilyFragment()

        }
    }

}



