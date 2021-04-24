package com.example.cryptoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.RemoteDataSource
import com.example.cryptoapp.data.CoinsRepositoryImpl
import com.example.cryptoapp.data.Mapper
import com.example.cryptoapp.data.MapperImpl
import com.example.cryptoapp.data.entity.CoinApiResponse
import com.example.cryptoapp.data.local.AppDatabase
import com.example.cryptoapp.data.remote.CoinAPI
import com.example.cryptoapp.data.remote.RemoteDataSourceImpl
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
    fun providesDataSource(coinsAPI: CoinAPI): RemoteDataSource {
        return RemoteDataSourceImpl(coinsAPI)
    }

    @Singleton
    @Provides
    fun providesRepository(remoteDataSource: RemoteDataSource,
                           mapper: Mapper<Coin, CoinApiResponse>): CoinsRepository {
        return CoinsRepositoryImpl(remoteDataSource, mapper)
    }

    @Singleton
    @Provides
    fun providesCoinsUseCase(coinsRepository: CoinsRepository): CoinsUseCase {
        return CoinsUseCaseImpl(coinsRepository)
    }

    @Singleton
    @Provides
    fun providesDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "crypto-db").build()
    }

}