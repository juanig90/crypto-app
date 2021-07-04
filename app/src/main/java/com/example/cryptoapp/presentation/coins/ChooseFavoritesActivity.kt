package com.example.cryptoapp.presentation.coins

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityChooseFavoriteBinding
import com.example.cryptoapp.domain.extension.showSnackbar
import com.example.cryptoapp.presentation.CoinsViewModel
import javax.inject.Inject

class ChooseFavoritesActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoinsViewModel> { viewModelFactory }

    private lateinit var binding: ActivityChooseFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CryptoApp).application.coinsComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_favorite)
        binding.activityCoinsRecycler.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))
        setSupportActionBar(binding.activityCoinToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        with(viewModel) {
            liveCoins.observe(this@ChooseFavoritesActivity, { items ->
                binding.activityCoinsRecycler.adapter = OptionItemAdapter(viewModel, items)
            })
            liveLoading.observe(this@ChooseFavoritesActivity, { isLoading ->
                binding.isLoading = isLoading
            })
            liveError.observe(this@ChooseFavoritesActivity, { msg ->
                showSnackbar(binding.root, msg) {
                    viewModel.onLoadCoins()
                }
            })
            onLoadCoins()
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            false
        } else super.onOptionsItemSelected(item)
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }

    companion object {

        fun startActivity(context: Activity) {
            Intent(context, ChooseFavoritesActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }


}