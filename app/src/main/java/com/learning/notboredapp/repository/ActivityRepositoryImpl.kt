package com.learning.notboredapp.repository

import com.learning.notboredapp.data.model.SuggestedActivity
import com.learning.notboredapp.data.remote.SuggestedActivityDataSource

class ActivityRepositoryImpl(private val dataSource: SuggestedActivityDataSource): IActivityRepository {
    override suspend fun getActivityByType(type: String): SuggestedActivity = dataSource.getActivityByType(type)

    override suspend fun getRandomActivity(participants: Int): SuggestedActivity = dataSource.getRandomActivity(participants)

}