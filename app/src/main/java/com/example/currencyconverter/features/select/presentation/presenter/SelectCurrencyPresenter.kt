package com.example.currencyconverter.features.select.presentation.presenter

import com.example.currencyconverter.features.BasePresenter
import com.example.currencyconverter.features.BaseView
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo

interface SelectCurrencyPresenter : BasePresenter {

    interface View : BaseView {
        fun showCurrenciesList(currencies: List<CurrencyInfo>)
    }
}