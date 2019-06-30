package com.example.currencyconverter.features.currency.domain.interactors.impl

import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.model.daily.Currency
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import com.example.currencyconverter.features.currency.domain.repository.CurrencyRepository
import io.reactivex.Completable
import io.reactivex.Observable

class CurrencyInteractorImpl(private val repository: CurrencyRepository) : CurrencyInteractor {

    override fun getCurrenciesFromNetwork(): Observable<ValCurs> = repository.getCurrenciesFromNetwork()

    override fun getCurrenciesInfoFromNetwork(): Observable<Valute> = repository.getCurrenciesInfoFromNetwork()

    override fun putCurrenciesInDatabase(currencies: List<Currency>?): Completable =
        repository.putCurrenciesInDatabase(currencies)

    override fun putCurrenciesInfoInDatabase(currenciesInfo: List<CurrencyInfo>?): Completable =
        repository.putCurrenciesInfoInDatabase(currenciesInfo)
}