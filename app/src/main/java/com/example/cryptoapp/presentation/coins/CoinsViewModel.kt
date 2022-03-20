package com.example.cryptoapp.presentation.coins

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase)
    : BaseViewModel<List<OptionItemUI>>() {

    fun onLoadCoins() {
        doWork {
            coinsUseCase.getOptionItems()
        }
    }

    fun onSwitchChanged(item: OptionItemUI, value: Boolean) {
        Log.d(TAG, "onSwitchChanged ${item.symbol} $value")
        viewModelScope.launch {
               if (value)
                   coinsUseCase.saveFavorite(item)
               else
                   coinsUseCase.removeFavorite(item)
           }
    }

}