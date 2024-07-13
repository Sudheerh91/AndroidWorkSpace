package com.android.lloyadsandroidtestapp.repository

import com.android.lloyadsandroidtestapp.model.DogFactsResponse


class DogFactsRepository {
    suspend fun fetchDogFacts(number: String): DogFactsResponse {
        var data = RetrofitClient.dogFactsApi.getDogFacts(number)
        println("RetrofitClient $data")
        return RetrofitClient.dogFactsApi.getDogFacts(number)
    }
}

