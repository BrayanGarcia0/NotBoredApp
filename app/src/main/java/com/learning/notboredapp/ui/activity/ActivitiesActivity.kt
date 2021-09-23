package com.learning.notboredapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.notboredapp.application.AppConstants
import com.learning.notboredapp.ui.activity.adapters.ActivitiesAdapter
import com.learning.notboredapp.core.Utils
import com.learning.notboredapp.databinding.ActivityActivitiesBinding
import com.learning.notboredapp.ui.activitydetails.SuggestedDetailActivity

class ActivitiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbarActivities)

        val objIntent: Intent =intent

        var participants = objIntent.getIntExtra("participants", 0)
        val listAdapter = ActivitiesAdapter(this, Utils.titleList)
        binding.listView.adapter = listAdapter

        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            println("${adapterView.getItemAtPosition(i)}")
            println(participants)
            gotoNextActivity(adapterView.getItemAtPosition(i).toString(), participants)

        }

        binding.imgBtnRandomActivity.setOnClickListener {
            gotoNextActivity(AppConstants.BLANK_SPACE, participants)
        }
    }

    fun gotoNextActivity(type: String, participants: Int){
        val nextActivityIntent: Intent = Intent(this, SuggestedDetailActivity::class.java)
        nextActivityIntent.putExtra("type", type)
        nextActivityIntent.putExtra("participants", participants)
        startActivity(nextActivityIntent)
    }
}