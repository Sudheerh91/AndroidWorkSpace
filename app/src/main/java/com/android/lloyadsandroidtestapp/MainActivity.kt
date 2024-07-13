package com.android.lloyadsandroidtestapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.lloyadsandroidtestapp.adapter.DogFactsAdapter
import com.android.lloyadsandroidtestapp.databinding.ActivityMainBinding
import com.android.lloyadsandroidtestapp.repository.DogFactsRepository
import com.android.lloyadsandroidtestapp.repository.ViewModelFactory
import com.android.lloyadsandroidtestapp.viewmodel.DogFactsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DogFactsViewModel
    private lateinit var adapter: DogFactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = DogFactsRepository()
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(DogFactsViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        adapter = DogFactsAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this) // Set the layout manager

        viewModel.dogFacts.observe(this, { facts ->
            adapter.submitList(facts)
        })

        viewModel.error.observe(this, { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        })

        // Fetch dog facts when the activity starts
        viewModel.getDogFacts("30")
    }
}

