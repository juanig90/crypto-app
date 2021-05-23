package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.RemoteDataSource
import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val client: CoinAPI): RemoteDataSource {

    override fun getCoins(): Single<List<RemoteCoin>> = client.getCoinsList()
    override fun getDetailCoin(id: String): Single<RemoteCoinDetail> = client.getCoinDetail(id)
}