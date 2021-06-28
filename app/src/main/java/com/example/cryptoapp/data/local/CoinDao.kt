package com.example.cryptoapp.data.local

import androidx.room.*
import com.example.cryptoapp.data.entity.LocalCoin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): Flow<List<LocalCoin>>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg coins: LocalCoin)

    @Delete
    fun delete(coin: LocalCoin)

}