package com.example.currencyconverter.features.currency.data.datasource.local.impl

import com.example.currencyconverter.database.AppDatabase
import com.example.currencyconverter.extension.toDouble
import com.example.currencyconverter.features.currency.data.datasource.local.LocalCurrencyDataSource
import com.example.currencyconverter.features.currency.data.entity.CurrencyEntity
import com.example.currencyconverter.features.currency.data.entity.CurrencyInfoEntity
import com.example.currencyconverter.features.currency.domain.model.daily.Currency
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalCurrencyDataSourceImpl(private val db: AppDatabase?) : LocalCurrencyDataSource {

    override fun putCurrenciesInDatabase(currencies: List<Currency>?): Completable =
        Completable.fromAction { putCurrencies(currencies!!) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun putCurrenciesInfoInDatabase(currenciesInfo: List<CurrencyInfo>?): Completable =
        Completable.fromAction { putCurrenciesInfo(currenciesInfo!!) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun putCurrencies(currencies: List<Currency>) {
        db!!.currencyDao().insertCurrencies(
            currencies.map {
                CurrencyEntity(it.id, it.charCode, it.nominal, it.value.toDouble(','))
            }
        )
    }

    fun putCurrenciesInfo(currenciesInfo: List<CurrencyInfo>) {
        db!!.currencyInfoDao().insertCurrenciesInfo(
            currenciesInfo.map {
                CurrencyInfoEntity(it.id, it.name, it.charCode)
            }
        )
    }
}