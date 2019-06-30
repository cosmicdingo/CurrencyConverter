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
    /*@field:Element(name = "EngName")
    var engName: String = "",
    @field:Element(name = "Nominal")
    var nominal: Int = -1,
    @field:Element(name = "ParentCode")
    var parentCode: String = "",*/
    @field:Element(name = "ISO_Num_Code", required = false)
    var numCode: Int = -1,
    @field:Element(name = "ISO_Char_Code", required = false)
    var charCode: String = ""
)