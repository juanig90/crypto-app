package com.example.cryptoapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.CardCoinItemBinding
import com.example.cryptoapp.databinding.CoinItemBinding
import com.example.cryptoapp.domain.entity.Coin

class CoinsAdapter(private val vm: CoinsViewModel,
                   private var coinUI: CoinUI): RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return when (viewType) {
            ViewTypes.CARD.value -> {
                val binding = CardCoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CardCoinViewHolder(binding)
            }
            else -> {
                val binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DefaultCoinViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinUI.coins[position])
    }

    override fun getItemCount() = coinUI.coins.size

    override fun getItemViewType(position: Int): Int {
        return when (coinUI) {
            is CoinUI.DefaultUI -> ViewTypes.DEFAULT.value
            is CoinUI.CardUI -> ViewTypes.CARD.value
        }
    }

    fun setData(coinUI: CoinUI) {
        this.coinUI = coinUI
        notifyDataSetChanged()
    }

    private enum class ViewTypes(val value: Int) {
        DEFAULT(0), CARD(1)
    }

    inner class DefaultCoinViewHolder(private val binding: CoinItemBinding): CoinViewHolder(binding.root) {

        override fun bind(coin: Coin) {
            binding.run {
                this.coin = coin
                coinItemSwitch.setOnCheckedChangeListener { _, isChecked ->
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

    sealed class CoinUI(val coins: List<Coin>) {

        class CardUI(coins: List<Coin>) : CoinUI(coins)
        class DefaultUI(coins: List<Coin>) : CoinUI(coins)
    }

}
