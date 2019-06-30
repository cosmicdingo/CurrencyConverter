package com.example.currencyconverter.features.select.presentation.presenter.impl

import android.annotation.SuppressLint
import android.util.Log
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.select.domain.interactors.SelectCurrencyInteractor
import com.example.currencyconverter.features.select.presentation.presenter.SelectCurrencyPresenter

class SelectCurrencyPresenterImpl(
    private val view: SelectCurrencyPresenter.View,
    private val interactor: SelectCurrencyInteractor
) : SelectCurrencyPresenter {

    val TAG = "SelectCurrencyPresenter"
    override fun onRecieve() {
        recieveCurrenciesInfo()
    }

    @SuppressLint("CheckResult")
    fun recieveCurrenciesInfo() {
        interactor.getCurrenciesInfo().subscribe(
            { t: List<CurrencyInfo> ->
                Log.d(TAG, "currencies are get")
                view.showCurrenciesList(t)
            },
            { t: Throwable? ->
                Log.d(TAG, "currencies are not get")
                t?.printStackTrace()
                view.showError()
            }
        )
    }
}