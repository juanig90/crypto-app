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
        val binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DefaultCoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinUI.coins[position])
    }

    override fun getItemCount() = coinUI.coins.size

    fun setData(coinUI: CoinUI) {
        this.coinUI = coinUI
        notifyDataSetChanged()
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
