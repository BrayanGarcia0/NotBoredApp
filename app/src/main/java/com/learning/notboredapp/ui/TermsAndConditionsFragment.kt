package com.learning.notboredapp.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.learning.notboredapp.R
import com.learning.notboredapp.databinding.FragmentTermsAndConditionsBinding

class TermsAndConditionsFragment : Fragment(R.layout.fragment_terms_and_conditions) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        val edit = view.findViewById<TextView>(R.id.textViewTermsAndConditionsDescription)
        val btn = view.findViewById<ImageButton>(R.id.btnTermsAndConditionsClose)
        edit.movementMethod = ScrollingMovementMethod()


        btn.setOnClickListener {
            (activity as FragmentActivity).supportFragmentManager.commit { replace<HomeFragment>(R.id.fragment_container_view) }
        }
    }
}