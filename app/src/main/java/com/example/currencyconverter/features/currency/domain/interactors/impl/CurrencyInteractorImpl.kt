package com.example.currencyconverter.features.currency.domain.interactors.impl

import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.Currency
import com.example.currencyconverter.features.currency.domain.model.ValCurs
import com.example.currencyconverter.features.currency.domain.repository.CurrencyRepository
import io.reactivex.Observable

class CurrencyInteractorImpl(private val repository: CurrencyRepository) : CurrencyInteractor {

    override fun getCurrenciesFromNetwork(): Observable<ValCurs> = repository.getCurrenciesFromNetwork()
}