package com.learning.notboredapp.data.remote

import com.learning.notboredapp.data.model.SuggestedActivity

class SuggestedActivityDataSource {

    fun getActivityByType(type: String): SuggestedActivity{
        return SuggestedActivity()
    }

    fun getRandomActivity(): SuggestedActivity{
        return SuggestedActivity()
    }
}