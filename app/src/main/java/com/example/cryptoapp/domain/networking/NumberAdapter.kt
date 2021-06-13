package com.example.cryptoapp.domain.networking

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

class NumberAdapter {

    @FromJson fun fromJson(string: String): Number {
        if(string.toIntOrNull() != null) return string.toInt()
        if(string.toFloatOrNull() != null) return string.toFloat()
        else throw JsonDataException("Is not a number")
    }

    @ToJson fun toJson(number: Number) = number.toString()

}