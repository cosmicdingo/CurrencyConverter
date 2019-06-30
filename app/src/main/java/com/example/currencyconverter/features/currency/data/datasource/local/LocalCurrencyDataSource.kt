package com.example.currencyconverter.features.currency.data.datasource.local

import com.example.currencyconverter.features.currency.domain.model.daily.Currency
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import io.reactivex.Completable

interface LocalCurrencyDataSource {

    fun putCurrenciesInDatabase(currencies: List<Currency>?): Completable

    fun putCurrenciesInfoInDatabase(currenciesInfo: List<CurrencyInfo>?): Completable
}