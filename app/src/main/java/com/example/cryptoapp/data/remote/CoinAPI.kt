package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.entity.CoinApiResponse

interface CoinAPI {

    fun getCoinsList(): List<CoinApiResponse>
}
