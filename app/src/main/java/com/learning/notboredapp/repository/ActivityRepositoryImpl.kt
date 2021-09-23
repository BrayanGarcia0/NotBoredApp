package com.learning.notboredapp.repository

import com.learning.notboredapp.data.model.SuggestedActivity
import com.learning.notboredapp.data.remote.SuggestedActivityDataSource

class ActivityRepositoryImpl(private val dataSource: SuggestedActivityDataSource): IActivityRepository {
    override suspend fun getActivityByType(type: String, participants: Int): SuggestedActivity = dataSource.getActivityByType(type, participants)

    override suspend fun getRandomActivity(participants: String): SuggestedActivity = dataSource.getRandomActivity(participants)

}