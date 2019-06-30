package com.example.currencyconverter.features.currency.presentation.presenter

import android.content.Intent
import com.example.currencyconverter.features.BasePresenter
import com.example.currencyconverter.features.BaseView
import com.example.currencyconverter.features.currency.domain.model.daily.Currency

interface CurrencyPresenter : BasePresenter {

    interface View: BaseView {
        //fun showCurrencies(currencies: List<Currency>?)
        fun startActivity()
    }
}