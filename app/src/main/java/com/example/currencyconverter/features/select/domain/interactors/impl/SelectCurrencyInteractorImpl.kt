package com.example.currencyconverter.features.select.domain.interactors.impl

import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.select.domain.interactors.SelectCurrencyInteractor
import com.example.currencyconverter.features.select.domain.repository.SelectCurrencyRepository
import io.reactivex.Single

class SelectCurrencyInteractorImpl(private val repository: SelectCurrencyRepository) : SelectCurrencyInteractor {

    override fun getCurrenciesInfo(): Single<List<CurrencyInfo>> = repository.getCurrenciesInfo()
}