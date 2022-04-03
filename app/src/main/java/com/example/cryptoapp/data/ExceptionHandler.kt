package com.example.cryptoapp.data

import com.example.cryptoapp.domain.core.resource.Result

interface ExceptionHandler {

   suspend fun <T> runCatch(block: suspend() -> T): Result<T>

}