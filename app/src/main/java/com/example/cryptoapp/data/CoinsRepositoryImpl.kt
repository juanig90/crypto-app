package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource,
    private val errorMapper: ErrorMapper
): CoinsRepository {

    override fun getOptionItems(): Single<Result<List<OptionItemUI>>> {
        val favoritesObservable = getFavoritesObservable().map { favorites ->
            favorites.map { OptionItemUI(it.id, it.symbol, true) }
        }
        return Single.zip(favoritesObservable, getRemoteCoins()) { favorites, remote ->
            val data = (favorites + remote).distinctBy { coin -> coin.symbol }
            Result.Success(data)
        }
    }

    override fun getFavoriteItems(): Single<Result<List<FavoriteItemUI>>> {
        return getFavoritesObservable().map { Result.Success(it) }
    }

    override fun getDetail(id: String): Single<Result<DetailUI>> {
       val detail = remoteData.getDetailCoin(id)
       val historical = remoteData.getHistoricalPrices(id).map { remoteHistorical ->
           remoteHistorical.prices.map { it[1] as Float }
       }
       return Single.zip(detail, historical) { coin, prices ->
           Result.Success(
               DetailUI(
                   name = coin.name,
                   percentageChange24h = coin.marketData.percentageChange24h.eur,
                   percentageChange1w = coin.marketData.percentageChange7d.eur,
                   percentageChange1m = coin.marketData.percentageChange30d.eur,
                   circulating = coin.marketData.circulatingSupply,
                   image = coin.image.large,
                   prices = prices
               )
           )
       }
    }

    override fun saveFavorite(item: OptionItemUI): Completable {
        return localData.saveCoins(LocalCoin(item.id, item.symbol))
    }

    override fun removeFavorite(item: OptionItemUI): Completable {
        return localData.deleteCoin(LocalCoin(item.id, item.symbol))
    }

    private fun getRemoteCoins(): Single<List<OptionItemUI>> {
        return remoteData.getCoins().map { coins ->
            coins.map { coin ->
                OptionItemUI(coin.id, coin.symbol, false)
            }
        }
    }

    private fun getFavoritesObservable(): Single<List<FavoriteItemUI>> {
        return localData.getCoins().map { coins ->
            coins.map { localCoin ->
                FavoriteItemUI(localCoin.id, localCoin.symbol)
            }
        }
    }

}