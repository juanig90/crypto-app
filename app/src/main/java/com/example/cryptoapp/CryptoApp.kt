package com.example.cryptoapp

import android.app.Application
import dagger.Component

@Component
interface ApplicationComponent {}

class CryptoApp : Application() {

    val application = DaggerApplicationComponent.create()

}