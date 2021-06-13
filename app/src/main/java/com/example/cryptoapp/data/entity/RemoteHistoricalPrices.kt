package com.example.cryptoapp.data.entity

import com.squareup.moshi.Json

data class RemoteHistoricalPrices(@Json(name = "prices") val prices: List<List<Number>>)
