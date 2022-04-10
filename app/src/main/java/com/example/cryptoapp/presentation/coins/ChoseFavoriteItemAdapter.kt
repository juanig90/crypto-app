package com.example.cryptoapp.presentation.coins

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ChoseFavoriteItemBinding
import com.example.cryptoapp.domain.entity.Coin

class ChoseFavoriteItemAdapter(private val vm: CoinsViewModel,
                               private val items: List<Coin>): RecyclerView.Adapter<ChoseFavoriteItemAdapter.ChooseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        val binding = ChoseFavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChooseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

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
