package com.example.currencyconverter.features.currency.presentation.presenter.impl

import android.annotation.SuppressLint
import android.util.Log
import com.example.currencyconverter.extension.toDouble
import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter

class CurrencyPresenterImpl(
    private val view: CurrencyPresenter.View,
    private val interactor: CurrencyInteractor
) : CurrencyPresenter {

    private val TAG = "CurrencyPresenterImpl"
    override fun onStart() {
        Log.d(TAG, "onResume")
        loadCurrencies()
        loadCurrenciesInfo()
    }

    @SuppressLint("CheckResult")
    private fun loadCurrencies() {
        Log.d(TAG, "loadCurrencies")
        interactor.getCurrenciesFromNetwork().subscribe(
            { t: ValCurs ->
                Log.d(TAG, "ValCurs.size = ${t.currencies?.size}")
                //view.showCurrencies(t.currencies)
               t.currencies?.forEach {
                   Log.d(TAG, "ValCurs.ID = ${it.id}")
                   Log.d(TAG, "ValCurs.charCode = ${it.charCode}")
                   Log.d(TAG, "ValCurs.nominal = ${it.nominal}")
                   Log.d(TAG, "ValCurs.value = ${it.value.toDouble(',')}")
               }
            },
            { error ->
                error.printStackTrace()
            }
        )
    }

    @SuppressLint("CheckResult")
    private fun loadCurrenciesInfo() {
        interactor.getCurrenciesInfoFromNetwork().subscribe(
            { t: Valute ->
                Log.d(TAG, "Valute.size = ${t.currenciesInfo?.size}")
                /*t.currenciesInfo?.forEach {
                    Log.d(TAG, "Valute.ID = ${it.id}")
                    Log.d(TAG, "Valute.name = ${it.name}")
                    Log.d(TAG, "Valute.charCode = ${it.charCode}")
                    Log.d(TAG, "Valute.numCode = ${it.numCode}")
                }*/
            },
            { error ->
                error.printStackTrace()
            }
        )
    }

}