package com.example.cryptoapp.domain.networking

import android.content.Context
import android.net.ConnectivityManager
import com.example.cryptoapp.domain.core.exceptions.ConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.lang.Exception
import kotlin.jvm.Throws

class ConnectivityInterceptor(private val context: Context): Interceptor {

    @Throws(Exception::class)
    override fun intercept(chain: Interceptor.Chain): Response {
      return if (!isConnected())
           throw ConnectivityException()
        else
            chain.proceed(chain.request())
    }

    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


}