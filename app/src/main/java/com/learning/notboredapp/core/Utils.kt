package com.learning.notboredapp.core

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.learning.notboredapp.R
import com.learning.notboredapp.databinding.ActivityMainBinding
import com.learning.notboredapp.ui.MainActivity

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
        context: Context,
        p0: String,
        view: View
    ) {
        val btnHome = view.findViewById<Button>(R.id.btnHome)

        when {
            p0.isEmpty() -> {
                btnHome.isEnabled = true
                btnHome.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.blueHome
                    )
                )
            }

            p0.toInt() == 0 -> {
                btnHome.isEnabled = false
                btnHome.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.gray
                    )
                )
            }
            else->{
                btnHome.isEnabled = true
                btnHome.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.blueHome
                    )
                )}
        }

    }
}