package com.example.currencyconverter.features.select.data

import com.example.currencyconverter.database.AppDatabase
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.select.domain.repository.SelectCurrencyRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SelectCurrencyRepositoryImpl(private val db: AppDatabase?) : SelectCurrencyRepository {

    override fun getCurrenciesInfo(): Single<List<CurrencyInfo>> =
            db!!.currencyInfoDao().getCurrenciesInfo().map {
                it.map {
                    CurrencyInfo(it.id, it.name, it.charCode)
                }
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
}