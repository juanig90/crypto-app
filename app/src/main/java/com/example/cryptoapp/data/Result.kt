package com.example.cryptoapp.data

sealed class Result<out T> {

    class Error(val msg: String): Result<Nothing>()
    class Success<out T>(val data: T): Result<T>()
    class Loading(val value: Boolean): Result<Nothing>()

}
