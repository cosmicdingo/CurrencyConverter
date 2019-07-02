package com.example.currencyconverter.features.select.presentation.presenter

import com.example.currencyconverter.features.BasePresenter
import com.example.currencyconverter.features.BaseView
import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId

interface SelectCurrencyPresenter : BasePresenter {

    interface View : BaseView {
        fun showCurrenciesList(currencies: List<CurrencyInfoWithoutId>)
    }
}