package com.example.currencyconverter.features.convert.domain.model

data class CurrencyWithInfo(
    val name: String,
    val charCode: String,
    val nominal: Int,
    val value: Double
)