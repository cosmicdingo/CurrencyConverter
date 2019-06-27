package com.example.currencyconverter.features.currency.presentation.presenter.impl

import android.annotation.SuppressLint
import android.util.Log
import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.Currency
import com.example.currencyconverter.features.currency.domain.model.ValCurs
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter

class CurrencyPresenterImpl(
    private val view: CurrencyPresenter.View,
    private val interactor: CurrencyInteractor
) : CurrencyPresenter {

    private val TAG = "CurrencyPresenterImpl"
    override fun onResume() {
        Log.d(TAG, "onResume")
        loadCurrencies()
    }

    @SuppressLint("CheckResult")
    private fun loadCurrencies() {
        Log.d(TAG, "loadCurrencies")
        view.hideProgress()

        interactor.getCurrenciesFromNetwork().subscribe(
            { t: ValCurs ->
                Log.d(TAG, "ValCurs.size = ${t.currencies?.size}")
                view.showCurrencies(t.currencies) },
            { error -> error.printStackTrace() }
        )
    }

}