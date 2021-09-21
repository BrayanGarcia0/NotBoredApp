package com.learning.notboredapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.notboredapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener { changeToSuggestions() }

        binding.tvTerms.setOnClickListener { changeToFragmentTerms() }
    }

    private fun changeToSuggestions() {
        TODO("Not yet implemented")
    }

    private fun changeToFragmentTerms() {
        TODO("Not yet implemented")
    }
}