package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.BuildConfig
import com.example.cryptoapp.data.ExceptionHandler
import com.example.cryptoapp.data.ExceptionHandlerImpl
import com.example.cryptoapp.domain.networking.ConnectivityInterceptor
import com.example.cryptoapp.domain.networking.NumberAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkingModule {

    @Singleton
    @Provides
    fun providesHttpClient(connectivityInterceptor: Interceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(NumberAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesConverter(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Singleton
    @Provides
    fun providesRetrofit(converter: Converter.Factory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesConnectivityInterceptor(context: Context): Interceptor {
       return ConnectivityInterceptor(context)
    }

    @Singleton
    @Provides
    fun providesErrorHandler(): ExceptionHandler {
        return ExceptionHandlerImpl()
    }

}