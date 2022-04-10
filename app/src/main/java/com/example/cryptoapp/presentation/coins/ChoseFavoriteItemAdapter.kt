package com.example.cryptoapp.presentation.coins

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ChoseFavoriteItemBinding
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.presentation.CoinDiffUtil

class ChoseFavoriteItemAdapter(private val vm: CoinsViewModel):
    ListAdapter<Coin, ChoseFavoriteItemAdapter.ChooseViewHolder>(CoinDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        val binding = ChoseFavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChooseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ChooseViewHolder(private val binding: ChoseFavoriteItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Coin) {
           with(binding) {
                coinItemName.text = item.symbol
                coinItemSwitch.setOnCheckedChangeListener { _, isChecked ->
                    vm.onSwitchChanged(item, isChecked)
                }
            }
        }

    }


}
