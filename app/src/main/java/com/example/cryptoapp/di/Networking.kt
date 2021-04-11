package com.example.cryptoapp.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    fun providesMoshi() = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun providesConverter(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
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