package com.example.currencyconverter.extension

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun String.toDouble(decimalSeparator: Char): Double {

    val df: DecimalFormat = DecimalFormat()
    val dfs: DecimalFormatSymbols = DecimalFormatSymbols()
    dfs.decimalSeparator = decimalSeparator
    df.decimalFormatSymbols = dfs

    return df.parse(this).toDouble()
}