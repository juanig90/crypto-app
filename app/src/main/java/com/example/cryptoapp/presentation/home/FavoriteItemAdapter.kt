package com.example.cryptoapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.FavoriteItemBinding
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.presentation.CoinDiffUtil
import com.example.cryptoapp.presentation.home.FavoriteItemAdapter.FavoriteViewHolder

class FavoriteItemAdapter(private val listener: (id: String) -> Unit):
    ListAdapter<Coin, FavoriteViewHolder>(CoinDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemAdapter.FavoriteViewHolder {
        val binding = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: FavoriteItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Coin) {
            with(binding) {
                favoriteItemSymbol.text = item.symbol
                itemView.setOnClickListener {
                    listener(item.id)
                }
            }
        }
    }

}
