package com.app.fragments.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.fragments.R
import com.app.fragments.presentation.feedback.FragmentFeedback
import com.app.fragments.presentation.home.FragmentHome
import com.app.fragments.presentation.settings.FragmentSettings
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var navigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navigation)
        navigation.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                replaceFragment(FragmentHome())
            }
            R.id.feedback -> {
                replaceFragment(FragmentFeedback())
            }
            R.id.settings -> {
                replaceFragment(FragmentSettings())
            }
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}