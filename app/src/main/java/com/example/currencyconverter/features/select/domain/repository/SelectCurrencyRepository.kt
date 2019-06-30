package com.example.currencyconverter.features.select.domain.repository

import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import io.reactivex.Single

interface SelectCurrencyRepository {
    fun getCurrenciesInfo(): Single<List<CurrencyInfo>>
}