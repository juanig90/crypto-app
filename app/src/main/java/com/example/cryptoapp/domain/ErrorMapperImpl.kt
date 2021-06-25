package com.example.cryptoapp.domain

import android.content.Context
import com.example.cryptoapp.R
import java.net.UnknownHostException

class ErrorMapperImpl(private val applicationContext: Context): ErrorMapper {

    override fun mapError(throwable: Throwable): String {
            return when(throwable) {
                is UnknownHostException -> applicationContext.getString(R.string.check_your_connection)
                else -> applicationContext.getString(R.string.unknown_error)
        }
    }
}
