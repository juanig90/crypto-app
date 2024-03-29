package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.core.resource.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.Coin


interface CoinsRepository {

    suspend fun getCoins(): Result<List<Coin>>
    suspend fun getFavoriteItems(): Result<List<Coin>>
    suspend fun saveFavorite(item: Coin)
    suspend fun removeFavorite(item: Coin)
    suspend fun getDetail(id: String): Result<DetailUI>
}