package com.example.currencyconverter.features.currency.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "char_code")
    val charCode: String,
    val nominal: Int,
    val value: Double
)