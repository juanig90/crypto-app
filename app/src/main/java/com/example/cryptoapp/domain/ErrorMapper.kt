package com.example.cryptoapp.domain

interface ErrorMapper {

    fun mapError(throwable: Throwable): String

}