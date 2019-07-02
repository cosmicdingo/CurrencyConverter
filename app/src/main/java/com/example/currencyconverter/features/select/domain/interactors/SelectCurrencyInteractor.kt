package com.example.currencyconverter.features.select.domain.interactors

import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId
import io.reactivex.Single

interface SelectCurrencyInteractor {

    fun getCurrenciesInfo(): Single<MutableList<CurrencyInfoWithoutId>>

    fun addRUCurrencyInfo(currencies: MutableList<CurrencyInfoWithoutId>): List<CurrencyInfoWithoutId>
}