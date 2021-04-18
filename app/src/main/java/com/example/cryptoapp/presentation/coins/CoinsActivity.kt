package com.example.cryptoapp.presentation.coins

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import javax.inject.Inject

class CoinsActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    private lateinit var recyclerCoins: RecyclerView

    private val coinAdapter = CoinsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CryptoApp).application.coinsComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coins)
        recyclerCoins = findViewById(R.id.activity_coins_recycler)
        recyclerCoins.adapter = coinAdapter
        viewModel.liveCoins.observe(this, { coins ->
            coinAdapter.coins = coins
        })
        viewModel.onLoadCoins()
    }
}