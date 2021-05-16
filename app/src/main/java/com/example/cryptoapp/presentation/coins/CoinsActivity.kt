package com.example.cryptoapp.presentation.coins

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityCoinsBinding
import com.example.cryptoapp.presentation.CoinsAdapter
import com.example.cryptoapp.presentation.CoinsViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class CoinsActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    private lateinit var binding: ActivityCoinsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CryptoApp).application.coinsComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coins)
        binding.activityCoinsRecycler.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))
        with(viewModel) {
            liveCoins.observe(this@CoinsActivity, { coinUI ->
                binding.activityCoinsRecycler.adapter = CoinsAdapter(this, coinUI)
            })
            liveLoading.observe(this@CoinsActivity, { isLoading ->
                binding.isLoading = isLoading
            })
            liveError.observe(this@CoinsActivity, {
                val snackbar = Snackbar.make(
                    binding.root,
                    getString(R.string.unknown_error),
                    Snackbar.LENGTH_INDEFINITE
                )
                snackbar.run {
                    setAction(getString(R.string.retry)) { viewModel.onLoadCoins() }
                    show()
                }
            })
            onLoadCoins()
        }
    }

    companion object {

        fun startActivity(context: Activity) {
            Intent(context, CoinsActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }


}