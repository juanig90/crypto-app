package com.example.cryptoapp.presentation.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityHomeBinding
import com.example.cryptoapp.presentation.CoinsAdapter
import com.example.cryptoapp.presentation.CoinsViewModel
import com.example.cryptoapp.presentation.GridItemDecoration
import com.example.cryptoapp.presentation.coins.CoinsActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as CryptoApp).application.homeComponent().create().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        with(binding) {
            activityHomeRecycler.run {
                layoutManager = GridLayoutManager(this@HomeActivity, 2)
                addItemDecoration(GridItemDecoration())
            }
            activityHomeFloatingButton.setOnClickListener {
                CoinsActivity.startActivity(this@HomeActivity)
            }
            viewModel.liveCoins.observe(this@HomeActivity, { coinUI ->
                activityHomeRecycler.adapter = CoinsAdapter(viewModel, coinUI)
            })
        }
        setSupportActionBar(findViewById(R.id.toolbar))
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