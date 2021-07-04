package com.example.cryptoapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.FavoriteCoinItemBinding
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.presentation.CoinsViewModel
import com.example.cryptoapp.presentation.home.FavoriteItemAdapter.FavoriteViewHolder

class FavoriteItemAdapter(private val vm: CoinsViewModel,
                          private val items: List<FavoriteItemUI>): RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemAdapter.FavoriteViewHolder {
        val binding = FavoriteCoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class FavoriteViewHolder(private val binding: FavoriteCoinItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FavoriteItemUI) {
            binding.item = item
            binding.cardCoinView.setOnClickListener {
                vm.onCoinSelected(item.id)
            }
        }
    }


}
