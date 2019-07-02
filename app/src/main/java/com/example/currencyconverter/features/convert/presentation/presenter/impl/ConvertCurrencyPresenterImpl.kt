package com.example.currencyconverter.features.convert.presentation.presenter.impl

import com.example.currencyconverter.features.convert.Carry
import com.example.currencyconverter.features.convert.domain.interactors.ConvertCurrencyInteractor
import com.example.currencyconverter.features.convert.presentation.presenter.ConvertCurrencyPresenter
import java.math.BigDecimal

class ConvertCurrencyPresenterImpl(
    private val view: ConvertCurrencyPresenter.View,
    private val interactor: ConvertCurrencyInteractor
) : ConvertCurrencyPresenter {

    override fun convertCurrencies(position: String, value: Double, charCodeIn: String, charCodeOut: String) {

        interactor.convertCurrencies(
            value = value,
            charCodeIn = charCodeIn,
            charCodeOut = charCodeOut,
            carry = object : Carry<BigDecimal> {
                override fun onSuccess(result: BigDecimal) {
                    view.showAnswer(position, result)
                }

                override fun onFailure() {
                    view.showError()
                }
            })
    }
}