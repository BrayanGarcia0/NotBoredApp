package com.learning.notboredapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.learning.notboredapp.R
import com.learning.notboredapp.databinding.FragmentHomeBinding

import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.learning.notboredapp.core.Utils
import com.learning.notboredapp.ui.activity.ActivitiesActivity


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonActivities = view.findViewById<Button>(R.id.btnHome)
        val etParticipants = view.findViewById<TextInputEditText>(R.id.editParticipants)
        val tvTerms = view.findViewById<TextView>(R.id.tvTerms)

        etParticipants.doAfterTextChanged { edit ->
            edit.toString()
                .let { context?.let { it1 -> Utils.validatorOfNroParticipants(it1, it, view) } }
        }

        buttonActivities.setOnClickListener {
            changeToActivities(etParticipants.text.toString())
        }

        tvTerms.setOnClickListener { changeToFragmentTerms() }

        return view
    }

    private fun changeToActivities(participants: String) {

        val intent = Intent(activity, ActivitiesActivity::class.java)


        if (participants.isNotEmpty()) {
            intent.putExtra("participants", participants.toInt())
        }
        
        startActivity(intent)

    }

    private fun changeToFragmentTerms() {
        (activity as FragmentActivity).supportFragmentManager.commit {
            replace<TermsAndConditionsFragment>(
                R.id.fragment_container_view
            )
        }
    }
}