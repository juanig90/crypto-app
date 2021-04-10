package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinApiResponse
import com.example.cryptoapp.domain.entity.Coin

class MapperImpl: Mapper<Coin, CoinApiResponse> {

    override fun fromEntityToDomainModel(entity: CoinApiResponse): Coin {
        return Coin(
            id = entity.id,
            symbol = entity.symbol,
            name = entity.name
        )
    }

    override fun fromDomainModelToEntity(domain: Coin): CoinApiResponse {
        return CoinApiResponse(
            id = domain.id,
            symbol = domain.symbol,
            name = domain.name
        )
    }
}