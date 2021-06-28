package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin

interface LocalDataSource {

    fun getCoins(): List<LocalCoin>
    fun saveCoins(vararg coins: LocalCoin)
    fun deleteCoin(coin: LocalCoin)
}