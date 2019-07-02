package com.example.currencyconverter.features.convert.domain.interactors

import com.example.currencyconverter.features.convert.Carry
import com.example.currencyconverter.features.convert.domain.model.CurrencyWithInfo
import io.reactivex.Single
import java.math.BigDecimal

interface ConvertCurrencyInteractor {

    fun convertCurrencies(value: Double, charCodeIn: String, charCodeOut: String, carry: Carry<BigDecimal>)
    fun getCurrencyInfo(charCode: String): Single<CurrencyWithInfo>
}