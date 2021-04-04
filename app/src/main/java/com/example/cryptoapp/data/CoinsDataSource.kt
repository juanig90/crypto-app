package com.example.cryptoapp.data

import com.example.cryptoapp.domain.entity.Coin

interface CoinsDataSource {

    fun getCoins(): List<Coin>
}