package com.example.cryptoapp.data.local

import androidx.room.*
import com.example.cryptoapp.data.entity.LocalCoin

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    suspend fun getAll(): List<LocalCoin>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg coins: LocalCoin)

    @Delete
    suspend fun delete(coin: LocalCoin)

}