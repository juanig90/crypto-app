package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getCoins(): Flow<List<LocalCoin>>
    fun saveCoins(vararg coins: LocalCoin)
    fun deleteCoin(coin: LocalCoin)
}