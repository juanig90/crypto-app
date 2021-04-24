package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.RemoteDataSource
import com.example.cryptoapp.data.entity.CoinApiResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val client: CoinAPI): RemoteDataSource {

    override fun getCoins(): Single<List<CoinApiResponse>> = client.getCoinsList()

}