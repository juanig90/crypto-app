package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val client: CoinAPI): RemoteDataSource {

    override suspend fun getCoins() = client.getCoinsList()
    override suspend fun getDetailCoin(id: String) = client.getCoinDetail(id)
    override suspend fun getHistoricalPrices(id: String) = client.getHistoricalCoin(id)
}