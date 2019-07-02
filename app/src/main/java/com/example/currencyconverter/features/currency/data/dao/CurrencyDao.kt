package com.example.currencyconverter.features.currency.data.dao

import androidx.room.*
import com.example.currencyconverter.features.currency.data.entity.CurrencyEntity
import com.example.currencyconverter.features.convert.domain.model.CurrencyWithInfo
import io.reactivex.Single

@Dao
interface CurrencyDao {

    @Query(
        "SELECT CurrencyInfoEntity.name, CurrencyInfoEntity.char_code AS charCode, " +
                "CurrencyEntity.nominal, CurrencyEntity.value FROM CurrencyInfoEntity, CurrencyEntity " +
                "WHERE CurrencyEntity.id == CurrencyInfoEntity.id AND CurrencyInfoEntity.char_code = :charCode"
    )
    fun getCurrencyWithInfo(charCode: String): Single<CurrencyWithInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(curruncies: List<CurrencyEntity>)
}