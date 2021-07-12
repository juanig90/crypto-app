package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import kotlinx.coroutines.flow.Flow

interface CoinsUseCase {

    suspend fun getOptionItems(): Flow<Result<List<OptionItemUI>>>
    suspend fun getFavoriteItems(): Flow<Result<List<FavoriteItemUI>>>
    suspend fun saveFavorite(item: OptionItemUI)
    suspend fun removeFavorite(item: OptionItemUI)
    suspend fun getDetail(id: String): Flow<Result<DetailUI>>
}