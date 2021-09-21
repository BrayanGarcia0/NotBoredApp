package com.learning.notboredapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.notboredapp.databinding.ActivityActivitiesBinding

class ActivitiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val objIntent: Intent =intent

        var participants = objIntent.getIntExtra("participants", 0)
        val listAdapter = ActivitiesAdapter(this, Utils.titleList)
        binding.listView.adapter = listAdapter
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            println("${adapterView.getItemAtPosition(i)}")
            println(participants)
        }
    }
}