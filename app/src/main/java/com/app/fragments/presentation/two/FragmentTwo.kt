package com.app.fragments.presentation.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.fragments.R

class FragmentTwo : Fragment() {

    private lateinit var tvMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragmento_two, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myValue = arguments?.getString("ios")

        tvMessage = view.findViewById(R.id.tvMessage)
        tvMessage.text = myValue
    }
}