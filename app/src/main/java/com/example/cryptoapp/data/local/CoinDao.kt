package com.example.cryptoapp.data.local

import androidx.room.*
import com.example.cryptoapp.data.entity.LocalCoin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): Flow<List<LocalCoin>>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg coins: LocalCoin)

    @Delete
    suspend fun delete(coin: LocalCoin)

}