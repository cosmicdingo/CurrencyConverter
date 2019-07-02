package com.example.currencyconverter.features.select.domain.interactors.impl

import com.example.currencyconverter.features.select.domain.interactors.SelectCurrencyInteractor
import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId
import com.example.currencyconverter.features.select.domain.repository.SelectCurrencyRepository
import io.reactivex.Single

class SelectCurrencyInteractorImpl(private val repository: SelectCurrencyRepository) : SelectCurrencyInteractor {

    override fun getCurrenciesInfo(): Single<MutableList<CurrencyInfoWithoutId>> = repository.getCurrenciesInfo()

    override fun addRUCurrencyInfo(currencies: MutableList<CurrencyInfoWithoutId>) =
        repository.addRUCurrencyInfo(currencies)
}