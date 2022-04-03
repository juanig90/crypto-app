package com.example.cryptoapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.FavoriteItemBinding
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.presentation.home.FavoriteItemAdapter.FavoriteViewHolder

class FavoriteItemAdapter(private val items: List<Coin>,
                          private val listener: (id: String) -> Unit): RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemAdapter.FavoriteViewHolder {
        val binding = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class FavoriteViewHolder(private val binding: FavoriteItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Coin) {
            binding.item = item
            binding.cardCoinView.setOnClickListener {
                listener(item.id)
            }
        }
    }


}
