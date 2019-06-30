package com.example.currencyconverter.features.select.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.select.presentation.view.OnSelectCurrencyListener

class SelectCurrencyAdapter(
    private val currencies: List<CurrencyInfo>?,
    private val onSelectCurrencyListener: OnSelectCurrencyListener
) :
    RecyclerView.Adapter<SelectCurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_item, parent, false)
        return ViewHolder(cardView)
    }

    override fun getItemCount() = currencies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        onBind(cardView, position)
        cardView.setOnClickListener {
            onSelectCurrencyListener.onSelectCurrency(currencies!![position].charCode)
        }
    }

    private fun onBind(cardView: View, position: Int) {

        val tvName: TextView = cardView.findViewById(R.id.tvName)
        tvName.text = currencies!![position].name

        val tvCharCode: TextView = cardView.findViewById(R.id.tvCharCode)
        tvCharCode.text = currencies[position].charCode
    }

    inner class ViewHolder(var cardView: View) : RecyclerView.ViewHolder(cardView)
}