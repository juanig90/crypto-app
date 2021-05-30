package com.example.cryptoapp.presentation

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.extension.format

object ViewBindings {

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun bindVisibility(view: View, value: Boolean) {
        if(value) view.visibility = VISIBLE else view.visibility = GONE
    }

    @JvmStatic
    @BindingAdapter("app:format")
    fun bindFormat(textView: TextView, value: Float?) {
        if (value == null) return
        val text = formatFloat(value, textView.context, true)
        textView.text = text
    }

    @JvmStatic
    @BindingAdapter("app:simple_format")
    fun bindSimpleFormat(textView: TextView, value: Float) {
        val text = formatFloat(value, textView.context, false)
        textView.text = text
    }

    @JvmStatic
    @BindingAdapter("app:icon")
    fun bindIcon(imageView: ImageView, value: Float) {
        if (value > 0)
            imageView.setImageResource(R.drawable.ic_expand_more_black)
        else
            imageView.setImageResource(R.drawable.ic_expand_less_black)
    }

    private fun formatFloat(value: Float,
                            context: Context,
                            includePercentageSymbol: Boolean = false): String {
        return if(includePercentageSymbol)
            context.getString(R.string.percentage_value, value.format(2))
        else
            value.format(2)
    }

}