package com.example.cryptoapp.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.presentation.coins.CoinsAdapter

object ViewBindings {

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun bindAdapter(recyclerView: RecyclerView, adapter: CoinsAdapter) {
        recyclerView.adapter = adapter
    }
}