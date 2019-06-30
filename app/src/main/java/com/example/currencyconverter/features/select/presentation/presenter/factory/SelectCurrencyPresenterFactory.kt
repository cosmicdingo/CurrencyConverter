package com.example.currencyconverter.features.select.presentation.presenter.factory

import android.content.Context
import com.example.currencyconverter.App
import com.example.currencyconverter.features.select.data.SelectCurrencyRepositoryImpl
import com.example.currencyconverter.features.select.domain.interactors.SelectCurrencyInteractor
import com.example.currencyconverter.features.select.domain.interactors.impl.SelectCurrencyInteractorImpl
import com.example.currencyconverter.features.select.domain.repository.SelectCurrencyRepository
import com.example.currencyconverter.features.select.presentation.presenter.SelectCurrencyPresenter
import com.example.currencyconverter.features.select.presentation.presenter.impl.SelectCurrencyPresenterImpl

class SelectCurrencyPresenterFactory {

    companion object {

        fun createPresenter(context: Context): SelectCurrencyPresenterImpl {

            val db = App.getDatabaseProvider(context)?.db

            val repository: SelectCurrencyRepository = SelectCurrencyRepositoryImpl(db)
            val interactor: SelectCurrencyInteractor = SelectCurrencyInteractorImpl(repository)

            return SelectCurrencyPresenterImpl(
                context as SelectCurrencyPresenter.View,
                interactor
            )
        }
    }
}