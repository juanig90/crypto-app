package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.Coin


interface CoinsRepository {

    suspend fun getOptionItems(): Result<List<Coin>>
    suspend fun getFavoriteItems(): Result<List<FavoriteItemUI>>
    suspend fun saveFavorite(item: Coin)
    suspend fun removeFavorite(item: Coin)
    suspend fun getDetail(id: String): Result<DetailUI>
}