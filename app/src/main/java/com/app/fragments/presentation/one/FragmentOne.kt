package com.app.fragments.presentation.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.fragments.R

class FragmentOne : Fragment() {

    private lateinit var tvMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myValue = arguments?.getString("android")

        tvMessage = view.findViewById(R.id.tvMessage)
        tvMessage.text = myValue
    }
}