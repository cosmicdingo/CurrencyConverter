package com.example.currencyconverter.features.currency.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.features.currency.domain.model.daily.Currency

class CurrencyAdapter(private val currencies: List<Currency>?) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_item, parent, false)
        return ViewHolder(cardView)
    }

    override fun getItemCount() = currencies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        onBind(cardView, position)
    }

    private fun onBind(cardView: View, position: Int) {

        val tvName: TextView = cardView.findViewById(R.id.tvName)
        tvName.text = currencies?.get(position)?.name ?: ""

        val tvCharCode: TextView = cardView.findViewById(R.id.tvCharCode)
        tvCharCode.text = currencies?.get(position)?.charCode ?: ""

        val tvNominal: TextView = cardView.findViewById(R.id.tvNominal)
        tvNominal.text = currencies?.get(position)?.nominal.toString()

        val tvValue: TextView = cardView.findViewById(R.id.tvValue)
        tvValue.text = currencies?.get(position)?.value ?: ""
    }

    inner class ViewHolder(var cardView: View) : RecyclerView.ViewHolder(cardView)
}