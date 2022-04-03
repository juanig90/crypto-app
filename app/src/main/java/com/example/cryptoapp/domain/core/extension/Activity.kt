package com.example.cryptoapp.domain.core.extension

import android.app.Activity
import android.view.View
import com.example.cryptoapp.R
import com.google.android.material.snackbar.Snackbar

fun Activity.showSnackbar(view: View, msg: String, onRetry: View.OnClickListener) {
    val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_INDEFINITE)
    snackbar.run {
        setAction(view.context.getString(R.string.retry), onRetry)
        show()
    }

}