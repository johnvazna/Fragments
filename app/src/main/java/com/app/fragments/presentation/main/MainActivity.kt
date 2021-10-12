package com.app.fragments.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.fragments.R
import com.app.fragments.presentation.one.FragmentOne
import com.app.fragments.presentation.two.FragmentTwo

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnOne : Button
    private lateinit var btnTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(FragmentOne(), null)

        btnOne = findViewById(R.id.btnOne)
        btnOne.setOnClickListener(this)

        btnTwo = findViewById(R.id.btnTwo)
        btnTwo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnOne -> {
                val bundle = Bundle()
                bundle.putString("android", "Android Developer")
                replaceFragment(FragmentOne(), bundle)
            }
            R.id.btnTwo -> {
                val bundle = Bundle()
                bundle.putString("ios", "iOS Developer")
                replaceFragment(FragmentTwo(), bundle)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, data: Bundle?) {
        fragment.arguments = data
        supportFragmentManager.beginTransaction().apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}