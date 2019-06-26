package com.example.currencyconverter.features.currency.presentation.presenter.impl

import android.annotation.SuppressLint
import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.Currency
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter

class CurrencyPresenterImpl(
    private val view: CurrencyPresenter.View,
    val interactor: CurrencyInteractor
) : CurrencyPresenter {

    override fun onCreate() {
        view.showProgress()
    }

    override fun onResume() {
        loadCurrencies()
    }

    @SuppressLint("CheckResult")
    private fun loadCurrencies() {
        view.hideProgress()

        interactor.getCurrenciesFromNetwork().subscribe(
            { t: List<Currency> -> view.showCurrentCurrencies(t) },
            { error -> error.printStackTrace() }
        )
    }

}