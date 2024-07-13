package com.android.lloyadsandroidtestapp.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.lloyadsandroidtestapp.viewmodel.DogFactsViewModel


class ViewModelFactory(private val repository: DogFactsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogFactsViewModel::class.java)) {
            return DogFactsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
