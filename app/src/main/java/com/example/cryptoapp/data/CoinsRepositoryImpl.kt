package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinApiResponse
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.core.Single

class CoinsRepositoryImpl(
    private val remoteData: RemoteDataSource,
    private val mapper: Mapper<Coin, CoinApiResponse>): CoinsRepository {

    override fun getCoins(): Single<List<Coin>> {
        return remoteData.getCoins().map { coins ->
            coins.map { coin ->
                mapper.fromEntityToDomainModel(coin)
            }
        }
    }
}