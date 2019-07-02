package com.example.currencyconverter.features.convert.presentation.presenter.factory

import android.content.Context
import com.example.currencyconverter.App
import com.example.currencyconverter.features.convert.data.ConvertCurrencyRepositoryImpl
import com.example.currencyconverter.features.convert.domain.interactors.ConvertCurrencyInteractor
import com.example.currencyconverter.features.convert.domain.interactors.impl.ConvertCurrencyInteractorImpl
import com.example.currencyconverter.features.convert.domain.repository.ConvertCurrencyRepository
import com.example.currencyconverter.features.convert.presentation.presenter.ConvertCurrencyPresenter
import com.example.currencyconverter.features.convert.presentation.presenter.impl.ConvertCurrencyPresenterImpl

class ConvertCurrencyPresenterFactory {

    companion object {

        fun createPresenter(context: Context): ConvertCurrencyPresenterImpl {

            val db = App.getDatabaseProvider(context)?.db

            val repository: ConvertCurrencyRepository = ConvertCurrencyRepositoryImpl(db)
            val interactor: ConvertCurrencyInteractor = ConvertCurrencyInteractorImpl(repository)

            return ConvertCurrencyPresenterImpl(
                context as ConvertCurrencyPresenter.View,
                interactor
            )
        }
    }
}