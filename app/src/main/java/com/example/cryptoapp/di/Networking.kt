package com.example.cryptoapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object Networking {

    @Singleton
    @Provides
    fun providesConverter(): Converter.Factory {
        return MoshiConverterFactory.create()
    }


    @Singleton
    @Provides
    fun providesRetrofit(converter: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3")
            .addConverterFactory(converter)
            .build()
    }

}