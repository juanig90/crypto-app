package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.di.DaggerApplicationComponent

class CryptoApp : Application() {

    val application = DaggerApplicationComponent.create()

}