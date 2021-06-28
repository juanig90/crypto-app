package com.example.cryptoapp.data.local

import androidx.room.*
import com.example.cryptoapp.data.entity.LocalCoin

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): List<LocalCoin>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg coins: LocalCoin)

    @Delete
    fun delete(coin: LocalCoin)

}