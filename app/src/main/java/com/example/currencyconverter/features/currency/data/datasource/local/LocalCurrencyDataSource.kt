package com.example.currencyconverter.features.currency.data.datasource.local

import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import io.reactivex.Completable
import io.reactivex.Observable

interface LocalCurrencyDataSource {

    fun putCurrenciesInDatabase(): Completable

    fun putCurrenciesInfoInDatabase(): Completable
}