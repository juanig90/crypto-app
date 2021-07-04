package com.example.cryptoapp.domain.entity

data class DetailUI(
    val name: String,
    val percentageChange24h: Float?,
    val percentageChange1w: Float?,
    val percentageChange1m: Float?,
    val circulating: Float,
    val image: String,
    val prices: List<Float>)
