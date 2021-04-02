package com.example.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CoinsActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CryptoApp).application.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coins_activity)
    }
}