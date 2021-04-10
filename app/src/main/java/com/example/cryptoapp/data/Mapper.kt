package com.example.cryptoapp.data

interface Mapper<DomainModel, Entity> {

    fun fromEntityToDomainModel(entity: Entity): DomainModel
    fun fromDomainModelToEntity(domain: DomainModel): Entity
}