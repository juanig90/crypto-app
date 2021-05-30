package com.example.cryptoapp.domain.extension

fun Float.format(digits: Int) = "%.${digits}f".format(this)