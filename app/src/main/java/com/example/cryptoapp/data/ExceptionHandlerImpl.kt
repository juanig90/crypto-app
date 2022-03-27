package com.example.cryptoapp.data

import com.example.cryptoapp.domain.exceptions.ClientError
import com.example.cryptoapp.domain.exceptions.ServerError
import com.example.cryptoapp.domain.exceptions.UnknownRequestError
import retrofit2.HttpException

class ExceptionHandlerImpl: ExceptionHandler {

    override suspend fun <T> runCatch(block: suspend() -> T): T {
        return try {
            block()
        }
        catch (e: HttpException) {
            val exception = when(e.code()) {
                in 400..499 -> ClientError(e.message())
                in 500..599 -> ServerError(e.message())
                else -> UnknownRequestError(e.message())
            }
            throw exception
        }
    }
}