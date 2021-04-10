package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinApiResponse

interface CoinsDataSource {

    fun getCoins(): List<CoinApiResponse>
}