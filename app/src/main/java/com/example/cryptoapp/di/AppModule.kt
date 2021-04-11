package com.example.cryptoapp.di

import com.example.cryptoapp.data.CoinsDataSource
import com.example.cryptoapp.data.CoinsRepositoryImpl
import com.example.cryptoapp.data.Mapper
import com.example.cryptoapp.data.MapperImpl
import com.example.cryptoapp.data.entity.CoinApiResponse
import com.example.cryptoapp.data.remote.CoinAPI
import com.example.cryptoapp.data.remote.CoinRemoteDataSource
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.domain.usecase.CoinsUseCaseImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun providesMapper(): Mapper<Coin, CoinApiResponse> = MapperImpl()

    @Singleton
    @Provides
    fun providesCoinsApi(retrofit: Retrofit): CoinAPI = retrofit.create(CoinAPI::class.java)

    @Singleton
    @Provides
    fun providesDataSource(coinsAPI: CoinAPI): CoinsDataSource {
        return CoinRemoteDataSource(coinsAPI)
    }

    @Singleton
    @Provides
    fun providesRepository(coinRemoteDataSource: CoinRemoteDataSource,
                           mapper: Mapper<Coin, CoinApiResponse>): CoinsRepository {
        return CoinsRepositoryImpl(coinRemoteDataSource, mapper)
    }

    @Singleton
    @Provides
    fun providesCoinsUseCase(coinsRepository: CoinsRepository): CoinsUseCase {
        return CoinsUseCaseImpl(coinsRepository)
    }

}