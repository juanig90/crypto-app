package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.OptionItemUI

interface CoinsUseCase {

    suspend fun getOptionItems(): Result<List<OptionItemUI>>
    suspend fun getFavoriteItems(): Result<List<FavoriteItemUI>>
    suspend fun saveFavorite(item: OptionItemUI)
    suspend fun removeFavorite(item: OptionItemUI)
    suspend fun getDetail(id: String): Result<DetailUI>
}