package com.example.cryptoapp.data.remote

import com.example.cryptoapp.domain.core.exceptions.ClientError
import com.example.cryptoapp.domain.core.exceptions.ServerError
import com.example.cryptoapp.domain.core.exceptions.UnknownRequestError
import retrofit2.HttpException

open class BaseRemoteDataSource {

    open suspend fun <T> runCatch(block: suspend() -> T): T {
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