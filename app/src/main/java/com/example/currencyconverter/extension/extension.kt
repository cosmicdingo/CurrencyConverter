package com.example.currencyconverter.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun String.toDouble(decimalSeparator: Char): Double {

    val df = DecimalFormat()
    val dfs = DecimalFormatSymbols()
    dfs.decimalSeparator = decimalSeparator
    df.decimalFormatSymbols = dfs

    return df.parse(this).toDouble()
}

fun BigDecimal.format(): String =
    DecimalFormat("#0.0000", DecimalFormatSymbols(Locale.US)).format(this)
