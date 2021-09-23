package com.learning.notboredapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.learning.notboredapp.core.Utils
import com.learning.notboredapp.databinding.ActivityMainBinding
import com.learning.notboredapp.presentation.SuggestionViewModel
import com.learning.notboredapp.ui.activity.ActivitiesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

