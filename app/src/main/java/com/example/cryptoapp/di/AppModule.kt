package com.example.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.example.cryptoapp.data.*
import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.local.AppDatabase
import com.example.cryptoapp.data.local.CoinDao
import com.example.cryptoapp.data.local.LocalDataSourceImpl
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
    fun providesMapper(): Mapper<Coin, RemoteCoin> = MapperImpl()

    @Singleton
    @Provides
    fun providesCoinsApi(retrofit: Retrofit): CoinAPI = retrofit.create(CoinAPI::class.java)

    @Singleton
    @Provides
    fun providesDao(database: AppDatabase): CoinDao {
        return database.coinDao()
    }

    @Singleton
    @Provides
    fun providesLocalDataSource(dao: CoinDao): LocalDataSource {
        return LocalDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun providesDataSource(coinsAPI: CoinAPI): RemoteDataSource {
        return RemoteDataSourceImpl(coinsAPI)
    }

    @Singleton
    @Provides
    fun providesRepository(localDataSource: LocalDataSource,
                           remoteDataSource: RemoteDataSource,
                           mapper: Mapper<Coin, RemoteCoin>): CoinsRepository {
        return CoinsRepositoryImpl(localDataSource, remoteDataSource, mapper)
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