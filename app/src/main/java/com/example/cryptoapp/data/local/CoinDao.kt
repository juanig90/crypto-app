package com.example.cryptoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.entity.LocalCoin
import io.reactivex.rxjava3.core.Single

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): Single<List<LocalCoin>>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg coins: LocalCoin)

}