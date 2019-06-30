package com.example.currencyconverter.features.select.domain.interactors

import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import io.reactivex.Single

interface SelectCurrencyInteractor {

    fun getCurrenciesInfo(): Single<List<CurrencyInfo>>
}