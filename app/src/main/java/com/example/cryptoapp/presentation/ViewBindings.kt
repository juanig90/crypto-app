package com.example.cryptoapp.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.presentation.coins.CoinsAdapter

object ViewBindings {

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun bindAdapter(recyclerView: RecyclerView, adapter: CoinsAdapter) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun bindVisibility(view: View, value: Boolean) {
        if(value) view.visibility = VISIBLE else view.visibility = GONE
    }
}