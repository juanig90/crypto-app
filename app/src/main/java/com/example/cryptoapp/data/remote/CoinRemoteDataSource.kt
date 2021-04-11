package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.CoinsDataSource
import com.example.cryptoapp.data.entity.CoinApiResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CoinRemoteDataSource @Inject constructor(private val client: CoinAPI): CoinsDataSource {

    override fun getCoins(): Single<List<CoinApiResponse>> = client.getCoinsList()

}