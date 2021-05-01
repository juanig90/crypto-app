package com.example.cryptoapp.data.local

import androidx.room.*
import com.example.cryptoapp.data.entity.LocalCoin
import io.reactivex.rxjava3.core.Single

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAll(): Single<List<LocalCoin>>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg coins: LocalCoin)

    @Delete
    fun delete(coin: LocalCoin)

}