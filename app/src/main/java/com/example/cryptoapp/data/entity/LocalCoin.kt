package com.example.cryptoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin")
data class LocalCoin(
    @PrimaryKey val id: String,
    val symbol: String,
    val name: String
)