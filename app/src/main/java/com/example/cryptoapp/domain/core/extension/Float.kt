package com.example.cryptoapp.domain.core.extension

fun Float.format(digits: Int) = "%.${digits}f".format(this)