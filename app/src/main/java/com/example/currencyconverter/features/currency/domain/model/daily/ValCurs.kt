package com.example.currencyconverter.features.currency.domain.model.daily

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs", strict = false)
data class ValCurs @JvmOverloads constructor(
    @field:ElementList(name = "Valute", inline = true)
    var currencies: List<Currency>? = null
)