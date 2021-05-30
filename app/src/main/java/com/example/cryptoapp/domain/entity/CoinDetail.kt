package com.example.cryptoapp.domain.entity

data class CoinDetail(
    val percentageChange24h: Float,
    val percentageChange1w: Float,
    val percentageChange1m: Float,
    val circulating: Float,
    val image: String)
