package com.example.cryptoapp.presentation.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DetailViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        (application as CryptoApp).application.detailComponent().create().inject(this)
        val id = intent.extras?.getString(COIN_ID_EXTRA) ?: throw IllegalArgumentException("Expected coin id")
        viewModel.apply {
            liveData.observe(this@DetailActivity, {
                Log.d(TAG, "Observe Data:$it ")
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