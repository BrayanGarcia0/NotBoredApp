package com.learning.notboredapp.data.model

data class SuggestedActivity(
    val activity: String = "",
    val accessibility: Double = 0.0,
    val type: String = "",
    val participants: Int = -1,
    val price: Double = 0.0,
    val key: Int = -1
)
