package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getCoins(): Flow<List<LocalCoin>>
    suspend fun saveCoins(vararg coins: LocalCoin)
    suspend fun deleteCoin(coin: LocalCoin)
}