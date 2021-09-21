package com.learning.notboredapp

import android.text.Editable
import androidx.core.content.ContextCompat
import com.learning.notboredapp.databinding.ActivityMainBinding

object Utils {
    val titleList: List<String> = listOf(
        "education",
        "recreational",
        "social",
        "diy",
        "charity",
        "cooking",
        "relaxation",
        "music",
        "busywork"
    )



    fun validatorOfNroParticipants(
        context: MainActivity,
        p0: Editable,
        binding: ActivityMainBinding
    ) {
        if (p0.toString().isEmpty()) {
            binding.btnHome.isEnabled = true
            binding.btnHome.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.blueHome
                )
            )
        } else if (p0.toString().toInt() == 0) {
            binding.btnHome.isEnabled = false
            binding.btnHome.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.gray
                )
            )
        }
    }
}