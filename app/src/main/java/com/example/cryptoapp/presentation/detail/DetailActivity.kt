package com.example.cryptoapp.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityDetailBinding
import com.example.cryptoapp.domain.extension.format
import com.example.cryptoapp.domain.extension.showSnackbar
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityDetailBinding

    private val viewModel by viewModels<DetailViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as CryptoApp).application.detailComponent().create().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val id = intent.extras?.getString(COIN_ID_EXTRA) ?: throw IllegalArgumentException("Expected coin id")
        setSupportActionBar(binding.activityDetailToolbar)
        viewModel.apply {
            liveData.observe(this@DetailActivity, {
                binding.run {
                    coin = it
                    price24 = getString(R.string.percentage_value, it.percentageChange24h?.format(2))
                    price1w = getString(R.string.percentage_value,it.percentageChange1w?.format(2))
                    price1m = getString(R.string.percentage_value,it.percentageChange1m?.format(2))
                    circulating = it.circulating.format(2)
                    activityDetailLineChartView.drawChart(it.prices)
                }
            })
            liveLoadingData.observe(this@DetailActivity, {
                binding.loading = it
            })
            liveDataError.observe(this@DetailActivity, { msg ->
                showSnackbar(binding.root, msg) {
                    viewModel.getDetail(id)
                }
            })
            getDetail(id)
        }
    }

    companion object {
        const val COIN_ID_EXTRA = "COIN_ID_EXTRA"
        private const val TAG = "DetailActivity"

        fun startActivity(context: Activity, id: String) {
            Intent(context, DetailActivity::class.java).apply {
                putExtra(COIN_ID_EXTRA, id)
                context.startActivity(this)
            }
        }
    }
}