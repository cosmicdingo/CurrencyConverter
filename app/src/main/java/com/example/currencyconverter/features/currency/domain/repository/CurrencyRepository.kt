package com.example.currencyconverter.features.currency.domain.repository

import com.example.currencyconverter.features.currency.domain.model.Currency
import io.reactivex.Observable

interface CurrencyRepository {

    // получить валюты с сервера
    fun getCurrenciesFromNetwork(): Observable<List<Currency>>
}