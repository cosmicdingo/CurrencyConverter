package com.example.currencyconverter.features.select.domain.repository

import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId
import io.reactivex.Single

interface SelectCurrencyRepository {

    fun getCurrenciesInfo(): Single<MutableList<CurrencyInfoWithoutId>>

    fun addRUCurrencyInfo(currencies: MutableList<CurrencyInfoWithoutId>): List<CurrencyInfoWithoutId>
}