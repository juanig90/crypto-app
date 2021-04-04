package com.example.cryptoapp.data.remote

import com.example.cryptoapp.domain.entity.Coin

interface CoinAPI {

    fun getCoinsList(): List<Coin>
}
