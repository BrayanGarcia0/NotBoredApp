package com.learning.notboredapp.data.service

import com.google.gson.GsonBuilder
import com.learning.notboredapp.application.AppConstants
import com.learning.notboredapp.data.model.SuggestedActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET(".")
    suspend fun getActivityByType(@Query("type") type: String): SuggestedActivity
    @GET(".")
    suspend fun getRandomActivity(@Query("participants") participants: Int): SuggestedActivity
}

object RetrofitClient {
    val webService  by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)

    }
}