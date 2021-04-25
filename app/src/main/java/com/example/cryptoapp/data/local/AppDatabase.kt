package com.example.cryptoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.entity.LocalCoin

@Database(entities = [LocalCoin::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun coinDao(): CoinDao
}