package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
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
       return remoteData.getDetailCoin(id).map { remote ->
           CoinDetail(
               name = remote.name,
               percentageChange24h = remote.marketData.percentageChange24h.eur,
               percentageChange1w = remote.marketData.percentageChange7d.eur,
               percentageChange1m = remote.marketData.percentageChange30d.eur,
               circulating = remote.marketData.circulatingSupply,
               image = remote.image.large
           )
       }
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