package com.example.cryptoapp.presentation

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cryptoapp.R

object ViewBindings {

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun bindVisibility(view: View, value: Boolean) {
        if(value) view.visibility = VISIBLE else view.visibility = GONE
    }

    @JvmStatic
    @BindingAdapter("app:icon")
    fun bindIcon(imageView: ImageView, value: Float) {
        if (value > 0)
            imageView.setImageResource(R.drawable.ic_expand_more_black)
        else
            imageView.setImageResource(R.drawable.ic_expand_less_black)
    }


}