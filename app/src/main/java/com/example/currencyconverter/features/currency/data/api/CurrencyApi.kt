package com.example.currencyconverter.features.currency.data.api

import com.example.currencyconverter.features.currency.domain.model.daily.ValCurs
import com.example.currencyconverter.features.currency.domain.model.info.Valute
import io.reactivex.Observable
import retrofit2.http.GET

interface CurrencyApi {

    @GET("XML_daily.asp")
    fun getCurrencies(): Observable<ValCurs>

    @GET("XML_valFull.asp")
    fun getCurrenciesFullInfo(): Observable<Valute>
}