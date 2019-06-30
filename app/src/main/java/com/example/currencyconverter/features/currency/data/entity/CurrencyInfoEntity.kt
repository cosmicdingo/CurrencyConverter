package com.example.currencyconverter.features.currency.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyInfoEntity(
    @PrimaryKey
    val id:String,
    val name: String,
    @ColumnInfo(name = "char_code")
    val charCode: String
)