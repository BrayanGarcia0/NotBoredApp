package com.learning.notboredapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.learning.notboredapp.databinding.CustomListBinding

class ActivitiesAdapter(private val context: Activity, private val titles: List<String>) :
    ArrayAdapter<String>(context, R.layout.custom_list, titles) {

    private lateinit var binding: CustomListBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        binding = CustomListBinding.inflate(LayoutInflater.from(context))
        val titleText = binding.tvTitleActivities
        titleText.text = titles[position]
        return binding.root

    }
}