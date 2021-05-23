package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAPI {

    @GET("coins/list")
    fun getCoinsList(): Single<List<RemoteCoin>>

    @GET("coins/{id}")
    fun getCoinDetail(@Path("id") id: Int): Single<List<RemoteCoinDetail>>
}
