package com.example.currencyconverter.features.convert.data

import com.example.currencyconverter.database.AppDatabase
import com.example.currencyconverter.features.convert.domain.model.CurrencyWithInfo
import com.example.currencyconverter.features.convert.domain.repository.ConvertCurrencyRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ConvertCurrencyRepositoryImpl(private val db: AppDatabase?) : ConvertCurrencyRepository {

    override fun getCurrencyInfo(charCode: String): Single<CurrencyWithInfo> =
        db!!.currencyDao().getCurrencyWithInfo(charCode)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}