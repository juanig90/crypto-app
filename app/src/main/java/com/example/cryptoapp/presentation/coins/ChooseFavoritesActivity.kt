package com.example.cryptoapp.presentation.coins

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.databinding.ActivityChooseFavoriteBinding
import com.example.cryptoapp.domain.core.extension.showSnackbar
import com.example.cryptoapp.presentation.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
        with(binding) {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.stateData.collect { result ->
                        when (result) {
                            is Result.Loading -> {
                                isLoading = result.value
                            }
                            is Result.Success -> {
                                isLoading = false
                                activityCoinsRecycler.adapter = OptionItemAdapter(
                                    viewModel,
                                    result.data
                                )
                            }
                            is Result.Error -> {
                                isLoading = false
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
                                viewModel.onLoadCoins()
                            }
                        }
                        is BaseViewModel.UIEvent.ToastEvent -> {
                            Toast.makeText(this@ChooseFavoritesActivity, event.msg, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        viewModel.onLoadCoins()
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