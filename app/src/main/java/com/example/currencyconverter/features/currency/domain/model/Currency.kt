package com.example.currencyconverter.features.currency.domain.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Valute", strict = false)
data class Currency(
    @Element(name = "NumCode")
    val numCode: Int,
    @Element(name = "CharCode")
    val charCode: String,
    @Element(name = "Nominal")
    val nominal: String,
    @Element(name = "Name")
    val name: String,
    @Element(name = "Value")
    val value: Float
)