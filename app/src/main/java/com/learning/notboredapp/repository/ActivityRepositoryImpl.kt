package com.learning.notboredapp.repository

import com.learning.notboredapp.data.model.SuggestedActivity

class ActivityRepositoryImpl: IActivityRepository {
    override suspend fun getActivityByType(type: String): SuggestedActivity {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomActivity(): SuggestedActivity {
        TODO("Not yet implemented")
    }

}