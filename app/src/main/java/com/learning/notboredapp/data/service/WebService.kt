package com.learning.notboredapp.data.service

import com.learning.notboredapp.data.model.SuggestedActivity
import retrofit2.http.GET

interface WebService {
    @GET()
    suspend fun getActivityByType(type: String): SuggestedActivity

    suspend fun getRandomActivity(): SuggestedActivity
}