package com.example.cryptoapp.presentation.coins

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.entity.Coin

class CoinsAdapter: RecyclerView.Adapter<CoinsAdapter.CoinViewHolder>() {

    var coins: List<Coin> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    override fun getItemCount() = coins.size

    inner class CoinViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val coinTextView = view.findViewById<TextView>(R.id.coin_item_name)

        fun bind(coin: Coin) {
            coinTextView.text = coin.name
        }

    }
}
