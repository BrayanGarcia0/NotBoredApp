package com.learning.notboredapp.repository

import com.learning.notboredapp.data.model.SuggestedActivity

interface IActivityRepository {

    suspend fun getActivityByType(type: String): SuggestedActivity

    suspend fun getRandomActivity(): SuggestedActivity
}