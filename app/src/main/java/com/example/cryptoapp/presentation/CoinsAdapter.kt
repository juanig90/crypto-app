package com.example.cryptoapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.CoinItemBinding
import com.example.cryptoapp.domain.entity.Coin

class CoinsAdapter(private val vm: CoinsViewModel): RecyclerView.Adapter<CoinsAdapter.CoinViewHolder>() {

    var coins: List<Coin> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    override fun getItemCount() = coins.size

    inner class CoinViewHolder(private val binding: CoinItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(coin: Coin) {
            binding.run {
                this.coin = coin
                coinItemSwitch.setOnCheckedChangeListener { _, isChecked ->
                    vm.onSwitchChanged(coin, isChecked)
                }
            }
        }

    }


    sealed class CoinUI(val coins: List<Coin>) {

        class CardUI(coins: List<Coin>) : CoinUI(coins)
        class DefaultUI(coins: List<Coin>) : CoinUI(coins)
    }

}
