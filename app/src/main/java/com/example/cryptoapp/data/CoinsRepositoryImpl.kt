package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.core.Single

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource,
    private val mapper: Mapper<Coin, RemoteCoin>): CoinsRepository {

    override fun getCoins(): Single<List<Coin>> {
        return remoteData.getCoins().map { coins ->
            coins.map { coin ->
                mapper.fromEntityToDomainModel(coin)
            }
        }
    }
}