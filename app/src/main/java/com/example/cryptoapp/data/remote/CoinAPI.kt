package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinAPI {

    @GET("coins/list")
    fun getCoinsList(): List<RemoteCoin>

    @GET("coins/{id}")
    fun getCoinDetail(@Path("id") id: String): RemoteCoinDetail

    @GET("coins/{id}/market_chart")
    fun getHistoricalCoin(
        @Path("id") id: String,
        @Query("vs_currency") currency: String = "eur",
        @Query("days") days: String = "30"
    ): RemoteHistoricalPrices
}
