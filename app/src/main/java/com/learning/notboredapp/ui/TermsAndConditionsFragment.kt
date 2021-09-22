package com.learning.notboredapp.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.learning.notboredapp.R
import com.learning.notboredapp.databinding.FragmentTermsAndConditionsBinding

class TermsAndConditionsFragment : Fragment(R.layout.fragment_terms_and_conditions) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.textViewTermsAndConditionsDescription)
        val btnClose = view.findViewById<Button>(R.id.btnTermsAndConditionsClose)
        text.movementMethod = ScrollingMovementMethod()

        btnClose.setOnClickListener{
            activity?.finish()
        }

    }
}