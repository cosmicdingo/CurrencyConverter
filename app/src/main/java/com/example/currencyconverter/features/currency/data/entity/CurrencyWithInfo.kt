package com.example.currencyconverter.features.currency.data.entity

data class CurrencyWithInfo(
    val name: String,
    val charCode: String,
    val nominal: Int,
    val value: Double
)