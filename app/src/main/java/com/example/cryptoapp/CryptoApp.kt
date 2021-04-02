package com.example.cryptoapp

import android.app.Application

class CryptoApp : Application() {

    val application = DaggerApplicationComponent.create()

}