package com.example.currencyconverter.features.currency.domain.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Valute", strict = false)
data class Currency @JvmOverloads constructor(
    @field:Element(name = "NumCode")
    var numCode: Int = -1,
    @field:Element(name = "CharCode")
    var charCode: String = "",
    @field:Element(name = "Nominal")
    var nominal: Int = -1,
    @field:Element(name = "Name")
    var name: String = "",
    @field:Element(name = "Value")
    var value: String = ""
)