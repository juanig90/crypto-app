package com.example.cryptoapp.data

import com.example.cryptoapp.domain.core.resource.Result

class ExceptionHandlerImpl: ExceptionHandler {

    override suspend fun <T> runCatch(block: suspend() -> T): Result<T> {
        return try {
           val data = block()
           Result.Success(data)
        }
        catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}