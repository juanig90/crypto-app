package com.example.cryptoapp.presentation.coins

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ChooseFavoriteItemBinding
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.presentation.CoinsViewModel

class OptionItemAdapter(private val vm: CoinsViewModel,
                        private val items: List<OptionItemUI>): RecyclerView.Adapter<OptionItemAdapter.ChooseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        val binding = ChooseFavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChooseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ChooseViewHolder(private val binding: ChooseFavoriteItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OptionItemUI) {
            binding.run {
                this.item = item
                coinItemSwitch.setOnCheckedChangeListener { _, isChecked ->
                    item.isFavorite = isChecked
                    vm.onSwitchChanged(item, isChecked)
                }
            }
        }

    }


}
