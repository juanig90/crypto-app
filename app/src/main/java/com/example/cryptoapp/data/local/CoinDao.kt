package com.example.cryptoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.entity.CoinLocal
import io.reactivex.rxjava3.core.Single

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): Single<CoinLocal>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(coins: List<CoinLocal>)

}