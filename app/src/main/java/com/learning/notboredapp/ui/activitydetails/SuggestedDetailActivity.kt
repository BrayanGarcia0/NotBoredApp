package com.learning.notboredapp.ui.activitydetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.learning.notboredapp.R
import com.learning.notboredapp.application.AppConstants
import com.learning.notboredapp.core.Resource
import com.learning.notboredapp.data.model.SuggestedActivity
import com.learning.notboredapp.data.remote.SuggestedActivityDataSource
import com.learning.notboredapp.data.service.RetrofitClient
import com.learning.notboredapp.databinding.ActivityMainBinding
import com.learning.notboredapp.databinding.ActivitySuggestedDetailBinding
import com.learning.notboredapp.presentation.SuggestionViewModel
import com.learning.notboredapp.presentation.SuggestionViewModelFactory
import com.learning.notboredapp.repository.ActivityRepositoryImpl

class SuggestedDetailActivity : AppCompatActivity() {


    val viewModel by viewModels<SuggestionViewModel> {
        SuggestionViewModelFactory(
            ActivityRepositoryImpl(
                SuggestedActivityDataSource(
                    RetrofitClient.webService
                )
            )
        )
    }
    lateinit var binding: ActivitySuggestedDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestedDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillView()
        binding.imgBtnReturnToActivities.setOnClickListener {
            finish()
        }

        binding.btnTryAnother.setOnClickListener {
            val newActivity = Intent(this, SuggestedDetailActivity::class.java)
            newActivity.putExtra("type", intent.getStringExtra("type"))
            newActivity.putExtra("participants", intent.getIntExtra("participants", -1))


            startActivity(newActivity)
            this.finish()
        }

    }

    private fun fillView() {
        val intentParameters = intent
        if (!intentParameters.getStringExtra("type").isNullOrEmpty()) {
            viewModel.suggestedActivityByType(intent.getStringExtra("type").toString().lowercase(), intent.getIntExtra("participants", 0))
                .observe(this, Observer { result ->
                    when (result) {
                        is Resource.Loading -> {
                            Log.d("LOADING", " Loading....")
                        }
                        is Resource.Success -> {
                            Log.d("LiveData", "${result.data}")
                            updateSuggestedActivity(result.data)
                        }
                        is Resource.Failure -> {
                            Log.d("ERROR", "${result.exception}")
                        }
                    }
                })
        } else {
            Log.d("problems", "Entra! ${intent.getIntExtra("participants", 1)}")
            viewModel.randomSuggestedActivity(intent.getIntExtra("participants", 1))
                .observe(this, Observer { result ->
                    when (result) {
                        is Resource.Loading -> {
                            Log.d("LOADING", " Loading....")
                        }
                        is Resource.Success -> {
                            Log.d("LiveData", "${result.data}")
                            updateRandomSuggestedActivity(result.data)
                        }
                        is Resource.Failure -> {
                            Log.d("ERROR", "${result.exception}")
                        }
                    }
                })
        }
    }

    fun updateSuggestedActivity(activity: SuggestedActivity) {
        binding.txtViewTitleSuggAct.text = activity.type
        updateGeneralTerms(activity)
    }

    fun updateGeneralTerms(activity: SuggestedActivity) {
        binding.textViewParticipantsNumber.text = activity.participants.toString()
        binding.textViewSuggActDesc.text = activity.activity
        updatePrice(activity.price)
    }

    fun updateRandomSuggestedActivity(activity: SuggestedActivity) {
        binding.txtViewTitleSuggAct.text = AppConstants.RANDOM
        binding.txtVwActName.visibility = TextView.VISIBLE
        binding.imageViewActType.visibility = ImageView.VISIBLE
        binding.txtVwActName.text = activity.type
        println(activity.type)
        updateGeneralTerms(activity)
    }

    fun updatePrice(price: Double) {
        binding.textViewPrice.text = when (price) {
            0.0 -> "FREE"
            in 0.0..0.3 -> "LOW"
            in 0.3..0.6 -> "MEDIUM"
            in 0.6..1.0 -> "HIGH"
            else -> "ERROR"
        }

    }
}