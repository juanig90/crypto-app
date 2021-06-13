package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {

    fun getCoins(): Single<List<RemoteCoin>>
    fun getDetailCoin(id: String): Single<RemoteCoinDetail>
    fun getHistoricalPrices(id: String): Single<RemoteHistoricalPrices>
}