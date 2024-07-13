package com.android.lloyadsandroidtestapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.lloyadsandroidtestapp.R

class DogFactsAdapter : ListAdapter<String, DogFactsAdapter.DogFactViewHolder>(DogFactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog_fact, parent, false)
        println("RetrofitClient3")
        return DogFactViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogFactViewHolder, position: Int) {
        val dogFact = getItem(position)
        println("RetrofitClient4 ")
        holder.bind(dogFact)
    }

    class DogFactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val factTextView: TextView = itemView.findViewById(R.id.factTextView)

        fun bind(dogFact: String) {
            factTextView.text = dogFact
        }
    }

    class DogFactDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }
}

