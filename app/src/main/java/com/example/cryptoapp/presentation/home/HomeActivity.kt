package com.example.cryptoapp.presentation.home

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cryptoapp.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityHomeBinding
import com.example.cryptoapp.presentation.GridItemDecoration
import com.example.cryptoapp.presentation.coins.ChooseFavoritesActivity
import com.example.cryptoapp.presentation.detail.DetailActivity
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

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
                ChooseFavoritesActivity.startActivity(this@HomeActivity)
            }
            viewModel.apply {
                liveLoading.observe(this@HomeActivity, {
                    isLoading = it
                })
                liveFavorites.observe(this@HomeActivity, { items ->
                    activityHomeRecycler.adapter = FavoriteItemAdapter(viewModel, items)
                })
                liveCoinSelected.observe(this@HomeActivity, { id ->
                    DetailActivity.startActivity(this@HomeActivity, id)
                })
            }
        }
        showUseCase()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onLoadFavorites()
    }

    private fun showUseCase() {
        val sharedPreferences = getSharedPreferences("crypto_app", MODE_PRIVATE)
        val isFirstUse = sharedPreferences.getBoolean(FIRST_USE, true)
        if (isFirstUse) {
            TapTargetView.showFor(
                this,
                TapTarget.forView(
                    binding.activityHomeFloatingButton, getString(R.string.title_show_case),
                    getString(R.string.show_case)
                )
                    .tintTarget(false)
                    .outerCircleColor(R.color.purple_500)
                    .outerCircleAlpha(0.96f)
                    .targetCircleColor(R.color.white)
                    .titleTextSize(20)
                    .titleTextColor(R.color.white)
                    .descriptionTextSize(10)
                    .textColor(R.color.switch_thumb_normal_material_light)
                    .textTypeface(Typeface.SANS_SERIF)
                    .dimColor(R.color.purple_500)
                    .drawShadow(true)
                    .cancelable(true)
                    .transparentTarget(false)
                    .targetRadius(60),
                object : TapTargetView.Listener() {
                    override fun onTargetClick(view: TapTargetView?) {
                        super.onTargetClick(view)
                        binding.activityHomeFloatingButton.performClick()
                    }
                })
            sharedPreferences.edit(commit = true) { putBoolean(FIRST_USE, false) }
        }
    }

    companion object {
        private const val FIRST_USE = "First use"
    }

}