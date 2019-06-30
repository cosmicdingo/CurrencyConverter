package com.example.currencyconverter.features.currency.presentation.presenter.factory

import android.content.Context
import com.example.currencyconverter.App
import com.example.currencyconverter.features.currency.data.CurrencyRepositoryImpl
import com.example.currencyconverter.features.currency.data.api.CurrencyApi
import com.example.currencyconverter.features.currency.data.datasource.local.LocalCurrencyDataSource
import com.example.currencyconverter.features.currency.data.datasource.local.impl.LocalCurrencyDataSourceImpl
import com.example.currencyconverter.features.currency.data.datasource.network.NetworkCurrencyDataSource
import com.example.currencyconverter.features.currency.data.datasource.network.impl.NetworkCurrencyDataSourceImpl
import com.example.currencyconverter.features.currency.domain.interactors.CurrencyInteractor
import com.example.currencyconverter.features.currency.domain.interactors.impl.CurrencyInteractorImpl
import com.example.currencyconverter.features.currency.domain.repository.CurrencyRepository
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter
import com.example.currencyconverter.features.currency.presentation.presenter.impl.CurrencyPresenterImpl

class PresenterFactory {

    companion object {

        fun createPresenter(context: Context): CurrencyPresenterImpl {

            val api: CurrencyApi? = App.getRetrofitProvider(context)
                ?.retrofit
                ?.create(CurrencyApi::class.java)

            val db = App.getDatabaseProvider(context)?.db

            val localDataSource: LocalCurrencyDataSource = LocalCurrencyDataSourceImpl(db)
            val networkDataSource: NetworkCurrencyDataSource = NetworkCurrencyDataSourceImpl(api)
            val repository: CurrencyRepository = CurrencyRepositoryImpl(networkDataSource, localDataSource)
            val interactor: CurrencyInteractor = CurrencyInteractorImpl(repository)

            return CurrencyPresenterImpl(
                context as CurrencyPresenter.View,
                interactor
            )
        }
    }
}