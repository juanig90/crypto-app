package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.RemoteDataSource
import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val client: CoinAPI): RemoteDataSource {

    override fun getCoins(): List<RemoteCoin> = client.getCoinsList()
    override fun getDetailCoin(id: String): RemoteCoinDetail = client.getCoinDetail(id)
    override fun getHistoricalPrices(id: String): RemoteHistoricalPrices = client.getHistoricalCoin(id)
}