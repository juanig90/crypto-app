package com.example.cryptoapp.data.entity

import com.squareup.moshi.Json

data class RemoteCoinDetail(
    val name: String,
    @Json(name = "market_data") val marketData: MarketData,
    val image: Image
)

data class Image(val thumb: String,
                 val small: String,
                 val large: String)

data class MarketData(@Json(name = "current_price") val currentPrice: CurrencyValue,
                      @Json(name = "high_24h") val high24h: CurrencyValue,
                      @Json(name = "low_24h") val low24h: CurrencyValue,
                      @Json(name = "price_change_percentage_1h_in_currency") val priceChangeOneHour: CurrencyValue,
                      @Json(name = "price_change_24h_in_currency") val priceChange24h: CurrencyValue,
                      @Json(name = "price_change_percentage_24h_in_currency") val percentageChange24h: CurrencyValue,
                      @Json(name = "price_change_percentage_7d_in_currency") val percentageChange7d: CurrencyValue,
                      @Json(name = "price_change_percentage_14d_in_currency") val percentageChange14d: CurrencyValue,
                      @Json(name = "price_change_percentage_30d_in_currency") val percentageChange30d: CurrencyValue,
                      @Json(name = "price_change_percentage_60d_in_currency") val percentageChange60d: CurrencyValue,
                      @Json(name = "price_change_percentage_1y_in_currency") val percentageChange1y: CurrencyValue,
                      @Json(name = "circulating_supply") val circulatingSupply: Float)

data class CurrentPrice(val currencyValue: CurrencyValue)

data class CurrencyValue(val eur: Float? = null)