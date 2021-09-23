package com.learning.notboredapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.learning.notboredapp.core.Resource
import com.learning.notboredapp.repository.IActivityRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class SuggestionViewModel(private val repo: IActivityRepository): ViewModel() {
    fun suggestedActivityByType(activityType: String) = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getActivityByType(activityType)))
        } catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun randomSuggestedActivity(participants: Int) = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getRandomActivity(participants)))
        } catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class SuggestionViewModelFactory(private val repo: IActivityRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IActivityRepository::class.java).newInstance(repo)
    }

}