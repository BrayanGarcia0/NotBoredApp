package com.learning.notboredapp.repository

import com.learning.notboredapp.data.model.SuggestedActivity

interface IActivityRepository {

    suspend fun getActivityByType(type: String, participants: Int): SuggestedActivity

    suspend fun getRandomActivity(participants: Int): SuggestedActivity
}