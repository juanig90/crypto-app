package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.ExceptionHandler
import com.example.cryptoapp.data.RemoteDataSource
import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val client: CoinAPI,
    private val exceptionHandler: ExceptionHandler
) : RemoteDataSource {

    override suspend fun getCoins(): List<RemoteCoin> {
       return exceptionHandler.runCatch {
            client.getCoinsList()
        }
    }
    override suspend fun getDetailCoin(id: String): RemoteCoinDetail {
       return exceptionHandler.runCatch {
           client.getCoinDetail(id)
       }
    }

    override suspend fun getHistoricalPrices(id: String): RemoteHistoricalPrices {
        return exceptionHandler.runCatch {
            client.getHistoricalCoin(id)
        }
    }

}