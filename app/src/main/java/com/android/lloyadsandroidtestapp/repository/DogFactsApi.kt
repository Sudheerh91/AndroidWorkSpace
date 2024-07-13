package com.android.lloyadsandroidtestapp.repository

import com.android.lloyadsandroidtestapp.model.DogFactsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface DogFactsApi {
    @GET("api/facts")
    suspend fun getDogFacts(@Query("number") number: String): DogFactsResponse
}