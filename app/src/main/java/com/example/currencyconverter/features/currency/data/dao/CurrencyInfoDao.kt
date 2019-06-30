package com.example.currencyconverter.features.currency.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.currencyconverter.features.currency.data.entity.CurrencyInfoEntity
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import io.reactivex.Single

@Dao
interface CurrencyInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCurrenciesInfo(currenciesInfo: List<CurrencyInfoEntity>)

    @Query("SELECT * FROM CurrencyInfoEntity")
    fun getCurrenciesInfo(): Single<List<CurrencyInfoEntity>>
}