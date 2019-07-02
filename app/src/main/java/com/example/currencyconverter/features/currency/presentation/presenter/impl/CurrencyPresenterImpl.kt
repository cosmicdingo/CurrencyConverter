package com.example.currencyconverter.features.currency.presentation.presenter.impl

import android.annotation.SuppressLint
import android.util.Log
import com.example.currencyconverter.R
import com.example.currencyconverter.extension.toDouble
import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter

class CurrencyPresenterImpl(
    private val view: CurrencyPresenter.View,
    private val interactor: CurrencyInteractor
) : CurrencyPresenter {

    override fun onRecieve() {
        loadCurrencies()
        loadCurrenciesInfo()
    }

    @SuppressLint("CheckResult")
    private fun loadCurrencies() {
        interactor.getCurrenciesFromNetwork().subscribe(
            { t: ValCurs ->
                interactor.putCurrenciesInDatabase(t.currencies).subscribe(
                    { view.startActivity() },
                    { error -> error.printStackTrace() }
                )
            },
            { error ->
                error.printStackTrace()
                view.showError()
            }
        )
    }

    @SuppressLint("CheckResult")
    private fun loadCurrenciesInfo() {
        interactor.getCurrenciesInfoFromNetwork().subscribe(
            { t: Valute ->
                interactor.putCurrenciesInfoInDatabase(t.currenciesInfo).subscribe(
                    { },
                    { error -> error.printStackTrace() }
                )
            },
            { error -> error.printStackTrace() }
        )
    }
}