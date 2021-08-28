package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin

interface LocalDataSource {

    suspend fun getCoins(): List<LocalCoin>
    suspend fun saveCoins(vararg coins: LocalCoin)
    suspend fun deleteCoin(coin: LocalCoin)
}