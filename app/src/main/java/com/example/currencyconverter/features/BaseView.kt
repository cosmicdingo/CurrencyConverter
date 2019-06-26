package com.example.currencyconverter.features

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String?)
}