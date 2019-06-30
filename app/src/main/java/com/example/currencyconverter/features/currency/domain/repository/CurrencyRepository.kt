package com.example.currencyconverter.features.currency.domain.repository

import com.example.currencyconverter.features.currency.domain.model.daily.Currency
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import io.reactivex.Completable
import io.reactivex.Observable

interface CurrencyRepository {

    // получить валюты с сервера
    fun getCurrenciesFromNetwork(): Observable<ValCurs>

    // получить информацию о валютах
    fun getCurrenciesInfoFromNetwork(): Observable<Valute>

    fun putCurrenciesInDatabase(currencies: List<Currency>?): Completable

    fun putCurrenciesInfoInDatabase(currenciesInfo: List<CurrencyInfo>?): Completable
}