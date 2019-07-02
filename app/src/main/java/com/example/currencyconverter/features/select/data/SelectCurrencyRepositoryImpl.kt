package com.example.currencyconverter.features.select.data

import com.example.currencyconverter.database.AppDatabase
import com.example.currencyconverter.features.select.domain.model.CurrencyInfoWithoutId
import com.example.currencyconverter.features.select.domain.repository.SelectCurrencyRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SelectCurrencyRepositoryImpl(private val db: AppDatabase?) : SelectCurrencyRepository {

    override fun getCurrenciesInfo(): Single<MutableList<CurrencyInfoWithoutId>> = db!!.currencyInfoDao().getCurrenciesInfo()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun addRUCurrencyInfo(currencies: MutableList<CurrencyInfoWithoutId>): List<CurrencyInfoWithoutId> {
        currencies.add(0, CurrencyInfoWithoutId("Российский рубль", "RUB"))
        return currencies
    }
}