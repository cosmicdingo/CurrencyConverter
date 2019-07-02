package com.example.currencyconverter.features.convert.domain.repository

import com.example.currencyconverter.features.convert.domain.model.CurrencyWithInfo
import io.reactivex.Single

interface ConvertCurrencyRepository {

    fun getCurrencyInfo(charCode: String): Single<CurrencyWithInfo>
}