package com.example.cryptoapp.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityHomeBinding
import com.example.cryptoapp.presentation.CoinsAdapter
import com.example.cryptoapp.presentation.CoinsAdapter.CoinUI.CardUI
import com.example.cryptoapp.presentation.CoinsViewModel
import com.example.cryptoapp.presentation.GridItemDecoration
import com.example.cryptoapp.presentation.coins.CoinsActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    private lateinit var binding: ActivityHomeBinding

    private lateinit var coinsAdapter: CoinsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as CryptoApp).application.homeComponent().create().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        coinsAdapter = CoinsAdapter(viewModel, CardUI(listOf()))
        with(binding) {
            adapter = coinsAdapter
            activityHomeRecycler.run {
                layoutManager = GridLayoutManager(this@HomeActivity, 2)
                addItemDecoration(GridItemDecoration())
            }
            activityHomeFloatingButton.setOnClickListener {
                CoinsActivity.startActivity(this@HomeActivity)
            }
        }
        setSupportActionBar(findViewById(R.id.toolbar))
        viewModel.liveCoins.observe(this, { coins ->
            coinsAdapter.setData(CardUI(coins))
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.onLoadCoins(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}