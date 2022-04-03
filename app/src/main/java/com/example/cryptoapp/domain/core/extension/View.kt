package com.example.cryptoapp.domain.core.extension

import android.view.View
import com.example.cryptoapp.R
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(msg: String, onRetry: View.OnClickListener) {
    val snackbar = Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE)
    snackbar.run {
        setAction(view.context.getString(R.string.retry), onRetry)
        show()
    }

}