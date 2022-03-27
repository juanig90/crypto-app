package com.example.cryptoapp.domain

import android.content.Context
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.exceptions.ClientError
import com.example.cryptoapp.domain.exceptions.ConnectivityException
import com.example.cryptoapp.domain.exceptions.ServerError

class ErrorMapperImpl(private val applicationContext: Context): ErrorMapper {

    override fun mapError(throwable: Throwable): String {
            return when(throwable) {
                is ConnectivityException -> applicationContext.getString(R.string.check_your_connection)
                is ClientError -> throwable.message ?: applicationContext.getString(R.string.bad_request)
                is ServerError -> throwable.message ?: applicationContext.getString(R.string.server_error)
                else -> applicationContext.getString(R.string.unknown_error)
        }
    }
}
