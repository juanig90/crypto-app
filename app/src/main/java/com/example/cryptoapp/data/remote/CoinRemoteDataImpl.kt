package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.CoinsRemoteDataSource
import com.example.cryptoapp.data.entity.CoinApiResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CoinRemoteDataImpl @Inject constructor(private val client: CoinAPI): CoinsRemoteDataSource {

    override fun getCoins(): Single<List<CoinApiResponse>> = client.getCoinsList()

}