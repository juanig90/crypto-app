package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices

interface RemoteDataSource {

    suspend fun getCoins(): List<RemoteCoin>
    suspend fun getDetailCoin(id: String): RemoteCoinDetail
    suspend fun getHistoricalPrices(id: String): RemoteHistoricalPrices
}