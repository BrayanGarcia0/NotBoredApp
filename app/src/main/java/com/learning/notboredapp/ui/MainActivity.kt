package com.learning.notboredapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.learning.notboredapp.core.Utils
import com.learning.notboredapp.databinding.ActivityMainBinding
import com.learning.notboredapp.ui.activity.ActivitiesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editParticipants.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                p0?.let { Utils.validatorOfNroParticipants(this@MainActivity, it, binding) }
                
            }
        })
        binding.btnHome.setOnClickListener {

            changeToActivities(binding.etParticipants.editText?.text.toString())
        }

        binding.tvTerms.setOnClickListener { changeToFragmentTerms() }
    }

    private fun changeToActivities(participants: String) {

        val intent = Intent(this, ActivitiesActivity::class.java)

        if (participants.isNotEmpty()) {

            intent.putExtra("participants", participants.toInt())
        }

        startActivity(intent)

    }

    private fun changeToFragmentTerms() {
        TODO("Not yet implemented")
    }
}