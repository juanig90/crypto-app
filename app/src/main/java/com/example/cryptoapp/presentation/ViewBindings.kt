package com.example.cryptoapp.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter

object ViewBindings {

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun bindVisibility(view: View, value: Boolean) {
        if(value) view.visibility = VISIBLE else view.visibility = GONE
    }
}