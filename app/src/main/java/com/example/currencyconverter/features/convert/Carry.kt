package com.example.currencyconverter.features.convert

interface Carry<T> {

    fun onSuccess(result: T)

    fun onFailure()
}