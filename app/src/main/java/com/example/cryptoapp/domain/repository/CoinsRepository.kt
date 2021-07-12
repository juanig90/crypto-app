package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import kotlinx.coroutines.flow.Flow


interface CoinsRepository {

    suspend fun getOptionItems(): Flow<Result<List<OptionItemUI>>>
    suspend fun getFavoriteItems(): Flow<Result<List<FavoriteItemUI>>>
    suspend fun saveFavorite(item: OptionItemUI)
    suspend fun removeFavorite(item: OptionItemUI)
    suspend fun getDetail(id: String): Flow<Result<DetailUI>>
}