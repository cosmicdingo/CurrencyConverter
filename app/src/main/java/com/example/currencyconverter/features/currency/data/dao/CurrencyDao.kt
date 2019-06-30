package com.example.currencyconverter.features.currency.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.currencyconverter.features.currency.data.entity.CurrencyEntity
import com.example.currencyconverter.features.currency.data.entity.CurrencyWithInfo
import io.reactivex.Single

@Dao
interface CurrencyDao {

    // подсчитываем количество данных в базе
    @Query("SELECT COUNT(*) FROM CurrencyEntity")
    fun countNumberRecords(): Single<Long>

    @Query(
        "SELECT CurrencyInfoEntity.name, CurrencyInfoEntity.char_code AS charCode, " +
                "CurrencyEntity.nominal, CurrencyEntity.value FROM CurrencyInfoEntity, CurrencyEntity " +
                "WHERE CurrencyEntity.id == CurrencyInfoEntity.id"
    )
    fun CurrenciesWithInfo(): Single<List<CurrencyWithInfo>>

    @Insert
    fun insertCurrencies(curruncies: List<CurrencyEntity>)

    @Update
    fun updateCurrencies(curruncies: List<CurrencyEntity>)
}