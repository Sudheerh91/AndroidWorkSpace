package com.android.lloyadsandroidtestapp.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://dog-api.kinduff.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dogFactsApi: DogFactsApi = retrofit.create(DogFactsApi::class.java)
}
