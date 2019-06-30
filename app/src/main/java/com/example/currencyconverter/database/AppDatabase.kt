package com.example.currencyconverter.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyconverter.features.currency.data.dao.CurrencyDao
import com.example.currencyconverter.features.currency.data.dao.CurrencyInfoDao
import com.example.currencyconverter.features.currency.data.entity.CurrencyEntity
import com.example.currencyconverter.features.currency.data.entity.CurrencyInfoEntity

@Database(entities = [CurrencyEntity::class, CurrencyInfoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun currencyInfoDao(): CurrencyInfoDao
}