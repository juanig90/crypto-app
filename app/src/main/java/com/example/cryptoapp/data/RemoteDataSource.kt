package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices

interface RemoteDataSource {

    fun getCoins(): List<RemoteCoin>
    fun getDetailCoin(id: String): RemoteCoinDetail
    fun getHistoricalPrices(id: String): RemoteHistoricalPrices
}