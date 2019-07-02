package com.example.currencyconverter.features.convert.presentation.presenter

import com.example.currencyconverter.features.BaseView
import java.math.BigDecimal

interface ConvertCurrencyPresenter {

    interface View : BaseView {
        fun showAnswer(position: String, answer: BigDecimal)
    }

    fun convertCurrencies(position: String, value: Double, charCodeIn: String, charCodeOut: String)
}