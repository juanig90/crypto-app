package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource,
    private val exceptionHandler: ExceptionHandler
): CoinsRepository {

    override suspend fun getOptionItems(): Result<List<Coin>> {
       return exceptionHandler.runCatch {
           val favorites = getFavorites().map { favorite ->
               Coin(favorite.id, favorite.symbol, true)
           }
           val remoteCoins = getRemoteCoins()
           val data = (favorites + remoteCoins).distinctBy { coin -> coin.symbol }
           data
        }
    }

    override suspend fun getFavoriteItems(): Result<List<FavoriteItemUI>> {
        return Result.Success(getFavorites())
    }

    override suspend fun getDetail(id: String): Result<DetailUI> {
        return exceptionHandler.runCatch {
            val detail = remoteData.getDetailCoin(id)
            val historical = remoteData.getHistoricalPrices(id).prices.map { it[1] as Float }
            DetailUI(
                name = detail.name,
                percentageChange24h = detail.marketData.percentageChange24h.eur,
                percentageChange1w = detail.marketData.percentageChange7d.eur,
                percentageChange1m = detail.marketData.percentageChange30d.eur,
                circulating = detail.marketData.circulatingSupply,
                image = detail.image.large,
                prices = historical
            )
        }
    }

    override suspend fun saveFavorite(item: Coin) {
        return localData.saveCoins(LocalCoin(item.id, item.symbol))
    }

    override suspend fun removeFavorite(item: Coin) {
        return localData.deleteCoin(LocalCoin(item.id, item.symbol))
    }

    private suspend fun getRemoteCoins(): List<Coin> {
        return remoteData.getCoins().map { coin ->
            Coin(coin.id, coin.symbol, false)
        }
    }

    private suspend fun getFavorites(): List<FavoriteItemUI> {
        return localData.getCoins().map { FavoriteItemUI(it.id, it.symbol) }
    }

}