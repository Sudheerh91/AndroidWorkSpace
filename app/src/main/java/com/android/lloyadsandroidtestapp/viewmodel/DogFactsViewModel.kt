package com.android.lloyadsandroidtestapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lloyadsandroidtestapp.repository.DogFactsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class DogFactsViewModel(private val repository: DogFactsRepository) : ViewModel() {

    private val _dogFacts = MutableLiveData<List<String>>()
    val dogFacts: LiveData<List<String>> get() = _dogFacts

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error


    fun getDogFacts(number: String) {
        viewModelScope.launch {
            try {
                val response = repository.fetchDogFacts(number)
                if (response.success) {
                    _dogFacts.value = response.facts
                    println("RetrofitClient5 Dog Facts: ${response.facts}")
                } else {
                    println("RetrofitClient6 Failed to fetch facts")
                    _error.value = "Failed to fetch facts."
                }
            } catch (e: HttpException) {
                _error.value = "Error: ${e.code()} - ${e.message()}"
            } catch (e: IOException) {
                _error.value = "Network Error: Please check your internet connection."
            } catch (e: Exception) {
                _error.value = "An unexpected error occurred."
            }
        }
    }

}


