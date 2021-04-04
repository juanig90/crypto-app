package com.example.cryptoapp.data

import com.example.cryptoapp.domain.entity.Coin

interface CoinAPI {

    fun getCoinsList(): List<Coin>
}
