package com.example.currencyconverter.features.currency.data

import com.example.currencyconverter.features.currency.data.datasource.local.LocalCurrencyDataSource
import com.example.currencyconverter.features.currency.data.datasource.network.NetworkCurrencyDataSource
import com.example.currencyconverter.features.currency.domain.model.daily.Currency
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import com.example.currencyconverter.features.currency.domain.repository.CurrencyRepository
import io.reactivex.Completable
import io.reactivex.Observable

class CurrencyRepositoryImpl(
    private val networkDataSource: NetworkCurrencyDataSource,
    private val localDataSource: LocalCurrencyDataSource
) : CurrencyRepository {

    override fun getCurrenciesFromNetwork(): Observable<ValCurs> = networkDataSource.getCurrenciesFromNetwork()

    override fun getCurrenciesInfoFromNetwork(): Observable<Valute> = networkDataSource.getCurrenciesInfoFromNetwork()

    override fun putCurrenciesInDatabase(currencies: List<Currency>?): Completable = localDataSource.putCurrenciesInDatabase(currencies)

    override fun putCurrenciesInfoInDatabase(currenciesInfo: List<CurrencyInfo>?): Completable = localDataSource.putCurrenciesInfoInDatabase(currenciesInfo)
}