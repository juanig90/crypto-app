package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource,
    private val errorMapper: ErrorMapper
): CoinsRepository {

    override suspend fun getOptionItems(): Flow<Result<List<OptionItemUI>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteItems(): Flow<Result<List<FavoriteItemUI>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetail(id: String): Flow<Result<DetailUI>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavorite(item: OptionItemUI) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorite(item: OptionItemUI) {
        TODO("Not yet implemented")
    }

    private fun getRemoteCoins(): Flow<List<OptionItemUI>> {
        TODO("Not yet implemented")
    }

    private fun getFavoritesObservable(): Flow<List<FavoriteItemUI>> {
        TODO("Not yet implemented")
    }

}