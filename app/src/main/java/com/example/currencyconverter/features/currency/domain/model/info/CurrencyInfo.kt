package com.example.currencyconverter.features.currency.domain.model.info

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Item", strict = false)
data class CurrencyInfo @JvmOverloads constructor(
    @field:Attribute(name = "ID")
    var id: String = "",
    @field:Element(name = "Name")
    var name: String = "",
    @field:Element(name = "ISO_Char_Code", required = false)
    var charCode: String = ""
)