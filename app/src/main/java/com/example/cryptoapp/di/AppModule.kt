package com.example.cryptoapp.di

import com.example.cryptoapp.data.CoinsDataSource
import com.example.cryptoapp.data.CoinsRepositoryImpl
import com.example.cryptoapp.data.remote.CoinAPI
import com.example.cryptoapp.data.remote.CoinRemoteDataSource
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.domain.usecase.CoinsUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun providesCoinsApi(): CoinAPI = object : CoinAPI {
        override fun getCoinsList(): List<Coin> {
            return listOf()
        }
    }

    @Singleton
    @Provides
    fun providesDataSource(coinsAPI: CoinAPI): CoinsDataSource {
        return CoinRemoteDataSource(coinsAPI)
    }

    @Singleton
    @Provides
    fun providesRepository(coinRemoteDataSource: CoinRemoteDataSource): CoinsRepository {
        return CoinsRepositoryImpl(coinRemoteDataSource)
    }

    @Singleton
    @Provides
    fun providesCoinsUseCase(coinsRepository: CoinsRepository): CoinsUseCase {
        return CoinsUseCaseImpl(coinsRepository)
    }

}