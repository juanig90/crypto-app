package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource): CoinsRepository {

    override fun getCoins(local: Boolean): Single<List<Coin>> {
        return if(local) getLocalCoins() else getAllCoins()
    }

    override fun getCoinDetail(id: String): Single<CoinDetail> {
       val detail = remoteData.getDetailCoin(id)
       val historical = remoteData.getHistoricalPrices(id).map { remoteHistorical ->
           remoteHistorical.prices.map { it[1] as Float }
       }
       return Single.zip(detail, historical) { coin, prices ->
           CoinDetail(
               name = coin.name,
               hasData =  hasData(coin),
               percentageChange24h = coin.marketData.percentageChange24h.eur,
               percentageChange1w = coin.marketData.percentageChange7d.eur,
               percentageChange1m = coin.marketData.percentageChange30d.eur,
               circulating = coin.marketData.circulatingSupply,
               image = coin.image.large,
               prices = prices
           )
       }
    }

    private fun hasData(coin: RemoteCoinDetail): Boolean {
        return coin.marketData.percentageChange24h.eur  != null ||
               coin.marketData.percentageChange7d.eur   != null ||
               coin.marketData.percentageChange30d.eur  != null
    }

    private fun getAllCoins(): @NonNull Single<List<Coin>> {
        return Single.zip(getLocalCoins(), getRemoteCoins()) { local, remote ->
            (local + remote).distinctBy { coin -> coin.id }
        }
    }

    private fun getRemoteCoins(): @NonNull Single<List<Coin>> {
        return remoteData.getCoins().map { coins ->
            coins.map { coin ->
                Coin(
                    id = coin.id,
                    symbol = coin.symbol,
                    name = coin.name
                )
            }
        }
    }

    private fun getLocalCoins(): Single<List<Coin>> {
        return localData.getCoins().map { coins ->
            coins.map { localCoin ->
                Coin(
                    id = localCoin.id,
                    symbol = localCoin.symbol,
                    name = localCoin.name,
                    isFavorite = true
                )
            }
        }
    }

    override fun saveCoin(coin: Coin): Completable {
        return localData.saveCoins(
            LocalCoin(
                id = coin.id,
                symbol = coin.symbol,
                name = coin.name
            )
        )
    }

    override fun deleteCoin(coin: Coin): Completable {
        return localData.deleteCoin(
            LocalCoin(
                id = coin.id,
                symbol = coin.symbol,
                name = coin.name
            )
        )
    }
}