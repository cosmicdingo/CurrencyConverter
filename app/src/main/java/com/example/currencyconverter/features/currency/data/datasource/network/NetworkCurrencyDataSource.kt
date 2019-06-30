package com.example.currencyconverter.features.currency.data.datasource.network

import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import io.reactivex.Observable

interface NetworkCurrencyDataSource {

    // получить валюты с сервера
    fun getCurrenciesFromNetwork(): Observable<ValCurs>

    // получить информацию о валютах
    fun getCurrenciesInfoFromNetwork(): Observable<Valute>
}