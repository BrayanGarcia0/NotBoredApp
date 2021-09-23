package com.learning.notboredapp.data.remote

import com.learning.notboredapp.data.model.SuggestedActivity
import com.learning.notboredapp.data.service.WebService

class SuggestedActivityDataSource(private val webService: WebService){

    suspend fun getActivityByType(type: String, participants: Int): SuggestedActivity{
        return webService.getActivityByType(type, participants)
    }

    suspend fun getRandomActivity(participants: String): SuggestedActivity{
        return webService.getRandomActivity(participants)
    }
}