package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.CoinsDataSource
import com.example.cryptoapp.domain.entity.Coin
import javax.inject.Inject

class CoinRemoteDataSource @Inject constructor(private val client: CoinAPI): CoinsDataSource {

    override fun getCoins(): List<Coin> = client.getCoinsList()

}