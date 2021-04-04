package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.CoinsDataSource
import com.example.cryptoapp.domain.entity.Coin

class CoinRemoteDataSource(private val client: CoinAPI): CoinsDataSource {

    override fun getCoins(): List<Coin> = client.getCoinsList()

}