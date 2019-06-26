package com.example.currencyconverter.features.currency.data.api

import com.example.currencyconverter.features.currency.domain.model.Currency
import io.reactivex.Observable
import retrofit2.http.GET

interface CurrencyApi {

    @GET("XML_daily.asp")
    fun getCurrencies(): Observable<List<Currency>>
}