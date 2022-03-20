package com.example.cryptoapp.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.databinding.ActivityDetailBinding
import com.example.cryptoapp.domain.extension.format
import com.example.cryptoapp.domain.extension.showSnackbar
import com.example.cryptoapp.presentation.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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
        with(binding) {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.stateData.collect { result ->
                        when (result) {
                            is Result.Loading -> {
                                loading = result.value
                            }
                            is Result.Success -> {
                                val detail = result.data
                                loading = false
                                coin = detail
                                price24 = getString(
                                    R.string.percentage_value,
                                    detail.percentageChange24h?.format(2)
                                )
                                price1w = getString(
                                    R.string.percentage_value,
                                    detail.percentageChange1w?.format(2)
                                )
                                price1m = getString(
                                    R.string.percentage_value,
                                    detail.percentageChange1m?.format(2)
                                )
                                circulating = detail.circulating.format(2)
                                activityDetailLineChartView.drawChart(detail.prices)
                            }
                            is Result.Error -> {
                                loading = false
                                // Show error view
                            }
                        }
                    }
                }
            }
            lifecycleScope.launch {
                viewModel.sharedEvent.collect { event ->
                    when (event) {
                        is BaseViewModel.UIEvent.SnackBarEvent -> {
                            showSnackbar(root, event.msg) {
                                viewModel.getDetail(id)
                            }
                        }
                        is BaseViewModel.UIEvent.ToastEvent -> {
                            Toast.makeText(this@DetailActivity, event.msg, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        viewModel.getDetail(id)
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