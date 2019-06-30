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

    private val TAG = "CurrencyPresenterImpl"
    override fun onRecieve() {
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
                interactor.putCurrenciesInDatabase(t.currencies).subscribe(
                    {
                        Log.d(TAG, "currencies added id database")
                        view.startActivity()
                    },
                    { error ->
                        error.printStackTrace()
                        Log.d(TAG, "currencies are not added id database")
                    }
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
                Log.d(TAG, "Valute.size = ${t.currenciesInfo?.size}")
                interactor.putCurrenciesInfoInDatabase(t.currenciesInfo).subscribe(
                    { Log.d(TAG, "currenciesInfo added id database") },
                    { error ->
                        error.printStackTrace()
                        Log.d(TAG, "currenciesInfo are not added id database")
                    }
                )
            },
            { error ->
                error.printStackTrace()
            }
        )
    }
}