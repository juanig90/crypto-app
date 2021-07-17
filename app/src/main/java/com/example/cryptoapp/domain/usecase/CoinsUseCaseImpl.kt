package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(private val repository: CoinsRepository) : CoinsUseCase {

    override suspend fun getOptionItems(): Flow<Result<List<OptionItemUI>>> {
        return repository.getOptionItems()
    }

    override suspend fun getFavoriteItems(): Flow<Result<List<FavoriteItemUI>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetail(id: String): Flow<Result<DetailUI>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavorite(item: OptionItemUI) {
        return repository.saveFavorite(item)
    }

    override suspend fun removeFavorite(item: OptionItemUI) {
        return repository.removeFavorite(item)
    }
}