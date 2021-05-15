package com.example.cryptoapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.CardCoinItemBinding
import com.example.cryptoapp.databinding.SwitchCoinItemBinding
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.presentation.CoinsViewModel.CoinUI

class CoinsAdapter(private val vm: CoinsViewModel,
                   private val coinUI: CoinUI): RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return when (viewType) {
            ViewTypes.CARD.value -> {
                val binding = CardCoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CardCoinViewHolder(binding)
            }
            else -> {
                val binding = SwitchCoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SwitchCoinViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinUI.coins[position])
    }

    override fun getItemCount() = coinUI.coins.size

    override fun getItemViewType(position: Int): Int {
        return when (coinUI) {
            is CoinUI.SwitchUI -> ViewTypes.SWITCH.value
            is CoinUI.CardUI -> ViewTypes.CARD.value
        }
    }

    private enum class ViewTypes(val value: Int) {
        SWITCH(0), CARD(1)
    }

    inner class SwitchCoinViewHolder(private val binding: SwitchCoinItemBinding): CoinViewHolder(binding.root) {

        override fun bind(coin: Coin) {
            binding.run {
                this.coin = coin
                coinItemSwitch.setOnCheckedChangeListener { _, isChecked ->
                    coin.isFavorite = isChecked
                    vm.onSwitchChanged(coin, isChecked)
                }
            }
        }

    }

    inner class CardCoinViewHolder(private val binding: CardCoinItemBinding): CoinViewHolder(binding.root) {

        override fun bind(coin: Coin) {
            binding.coin = coin
        }
    }


}
