package com.example.currencyconverter.features.select.presentation.presenter.impl

import android.annotation.SuppressLint
import com.example.currencyconverter.features.select.domain.interactors.SelectCurrencyInteractor
import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId
import com.example.currencyconverter.features.select.presentation.presenter.SelectCurrencyPresenter

class SelectCurrencyPresenterImpl(
    private val view: SelectCurrencyPresenter.View,
    private val interactor: SelectCurrencyInteractor
) : SelectCurrencyPresenter {

    override fun onRecieve() {
        recieveCurrenciesList()
    }

    @SuppressLint("CheckResult")
    fun recieveCurrenciesList() {
        interactor.getCurrenciesInfo().subscribe(
            { t: MutableList<CurrencyInfoWithoutId> ->
                view.showCurrenciesList(interactor.addRUCurrencyInfo(t))
            },
            { view.showError() }
        )
    }
}