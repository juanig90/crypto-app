package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.entity.Coin

interface CoinsRepository {

    fun getCoins(): List<Coin>
}