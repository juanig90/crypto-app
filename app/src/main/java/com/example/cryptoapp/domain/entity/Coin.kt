package com.example.cryptoapp.domain.entity

data class Coin(
        val id: String,
        val symbol: String,
        val name: String,
        val isFavorite: Boolean = false)