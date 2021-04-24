package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinApiResponse
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {

    fun getCoins(): Single<List<CoinApiResponse>>
}