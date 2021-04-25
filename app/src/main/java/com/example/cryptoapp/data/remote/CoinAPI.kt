package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.entity.RemoteCoin
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CoinAPI {

    @GET("coins/list")
    fun getCoinsList(): Single<List<RemoteCoin>>
}
