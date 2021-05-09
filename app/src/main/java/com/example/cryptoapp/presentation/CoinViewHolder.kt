package com.example.cryptoapp.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.domain.entity.Coin

abstract class CoinViewHolder(view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(coin: Coin)
}