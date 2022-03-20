package com.example.cryptoapp.presentation.coins

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.usecase.RemoveFavoriteUseCase
import com.example.cryptoapp.domain.usecase.SaveFavoriteUseCase
import com.example.cryptoapp.domain.usecase.SelectionCoinUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(
    private val selectionCoinUseCase: SelectionCoinUseCase,
    private val saveFavoriteUseCase: SaveFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : BaseViewModel<List<OptionItemUI>>() {

    fun onLoadCoins() {
        doWork {
            selectionCoinUseCase()
        }
    }

    fun onSwitchChanged(item: OptionItemUI, value: Boolean) {
        Log.d(TAG, "onSwitchChanged ${item.symbol} $value")
        viewModelScope.launch {
               if (value)
                   saveFavoriteUseCase(item)
               else
                   removeFavoriteUseCase(item)
           }
    }

}