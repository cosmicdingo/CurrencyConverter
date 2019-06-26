package com.example.currencyconverter.features.currency.domain.interactors

import com.example.currencyconverter.features.currency.domain.model.Currency
import io.reactivex.Observable

interface CurrencyInteractor {

    // получить валюты с сервера
    fun getCurrenciesFromNetwork(): Observable<List<Currency>>
}