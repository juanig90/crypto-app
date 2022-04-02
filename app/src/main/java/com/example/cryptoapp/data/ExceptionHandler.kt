package com.example.cryptoapp.data

interface ExceptionHandler {

   suspend fun <T> runCatch(block: suspend() -> T): Result<T>

}