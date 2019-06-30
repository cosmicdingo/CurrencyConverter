package com.example.currencyconverter.features.currency.domain.model.info

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "Valuta", strict = false)
data class Valute @JvmOverloads constructor(
    @field:ElementList(name = "Item", inline = true)
    var currenciesInfo: List<CurrencyInfo>? = null
)