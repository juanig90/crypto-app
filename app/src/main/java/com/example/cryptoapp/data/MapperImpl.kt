package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.domain.entity.Coin

class MapperImpl: Mapper<Coin, RemoteCoin> {

    override fun fromEntityToDomainModel(entity: RemoteCoin): Coin {
        return Coin(
            id = entity.id,
            symbol = entity.symbol,
            name = entity.name
        )
    }

    override fun fromDomainModelToEntity(domain: Coin): RemoteCoin {
        return RemoteCoin(
            id = domain.id,
            symbol = domain.symbol,
            name = domain.name
        )
    }
}