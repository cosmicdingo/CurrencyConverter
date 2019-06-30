package com.example.currencyconverter.features.currency.data.datasource.network.impl

import com.example.currencyconverter.features.currency.data.api.CurrencyApi
import com.example.currencyconverter.features.currency.data.datasource.network.NetworkCurrencyDataSource
import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NetworkCurrencyDataSourceImpl(private val api: CurrencyApi?) : NetworkCurrencyDataSource {

    override fun getCurrenciesFromNetwork(): Observable<ValCurs> {
        return api!!.getCurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getCurrenciesInfoFromNetwork(): Observable<Valute> {
        return api!!.getCurrenciesFullInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}