package com.example.cryptoapp.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityDetailBinding
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
                Log.d(TAG, "Observe Data:$it ")
                binding.coin = it
                Glide.with(this@DetailActivity).load(it.image).into(binding.activityDetailCoinImage)
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