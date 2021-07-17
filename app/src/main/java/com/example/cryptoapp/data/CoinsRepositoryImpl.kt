package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource,
    private val errorMapper: ErrorMapper
): CoinsRepository {

    override suspend fun getOptionItems(): Flow<Result<List<OptionItemUI>>> {
        val favoritesFlow = getFavoritesFlow().map { favorites ->
            favorites.map { OptionItemUI(it.id, it.symbol, true) }
        }
        return combine(favoritesFlow, getRemoteCoins()) { favorites, remote ->
            val data = (favorites + remote).distinctBy { coin -> coin.symbol }
            Result.Success(data)
        }.catch {
            val msg = errorMapper.mapError(it)
            Result.Error(msg)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getFavoriteItems(): Flow<Result<List<FavoriteItemUI>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetail(id: String): Flow<Result<DetailUI>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavorite(item: OptionItemUI) {
        return localData.saveCoins(LocalCoin(item.id, item.symbol))
    }

    override suspend fun removeFavorite(item: OptionItemUI) {
        return localData.deleteCoin(LocalCoin(item.id, item.symbol))
    }

    private suspend fun getRemoteCoins(): Flow<List<OptionItemUI>> {
        return remoteData.getCoins().map { coins ->
            coins.map { coin ->
                OptionItemUI(coin.id, coin.symbol, false)
            }
        }
    }

    private suspend fun getFavoritesFlow(): Flow<List<FavoriteItemUI>> {
        return flow {
            val data = localData.getCoins().map { FavoriteItemUI(it.id, it.symbol) }
            emit(data)
        }
    }

}