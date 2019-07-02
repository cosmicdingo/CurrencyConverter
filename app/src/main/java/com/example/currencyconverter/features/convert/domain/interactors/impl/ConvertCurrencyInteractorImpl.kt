package com.example.currencyconverter.features.convert.domain.interactors.impl

import android.annotation.SuppressLint
import com.example.currencyconverter.features.convert.Carry
import com.example.currencyconverter.features.convert.domain.interactors.ConvertCurrencyInteractor
import com.example.currencyconverter.features.convert.domain.model.CurrencyWithInfo
import com.example.currencyconverter.features.convert.domain.repository.ConvertCurrencyRepository
import io.reactivex.Single
import java.math.BigDecimal

class ConvertCurrencyInteractorImpl(
    private val repository: ConvertCurrencyRepository
) : ConvertCurrencyInteractor {

    override fun getCurrencyInfo(charCode: String): Single<CurrencyWithInfo> =
        repository.getCurrencyInfo(charCode)

    @SuppressLint("CheckResult")
    override fun convertCurrencies(value: Double, charCodeIn: String, charCodeOut: String, carry: Carry<BigDecimal>) {

        if ("RUB".equals(charCodeIn)) {
            repository.getCurrencyInfo(charCodeOut).subscribe(
                { t: CurrencyWithInfo ->
                    carry.onSuccess(
                        calcValue(
                            targetValue = BigDecimal.valueOf(value),
                            valueInRub = t.value,
                            nominal = t.nominal.toDouble()
                        )
                    )
                },
                {
                    carry.onFailure()
                }
            )
        } else {
            repository.getCurrencyInfo(charCodeIn).subscribe(
                { t: CurrencyWithInfo ->
                    // находим сколько составляет переводимая валюта в рублях
                    val result: BigDecimal = calcValue(
                        targetValue = BigDecimal.valueOf(value),
                        valueInRub = t.nominal.toDouble(),
                        nominal = t.value
                    )
                    if ("RUB".equals(charCodeOut))
                        carry.onSuccess(result)
                    else repository.getCurrencyInfo(charCodeOut).subscribe { t1: CurrencyWithInfo ->
                        carry.onSuccess(
                            calcValue(
                                targetValue = result,
                                valueInRub = t1.value,
                                nominal = t1.nominal.toDouble()
                            )
                        )
                    }
                },
                {
                    carry.onFailure()
                })
        }
    }

    fun calcValue(targetValue: BigDecimal, valueInRub: Double, nominal: Double): BigDecimal =
        targetValue * (BigDecimal.valueOf(nominal / valueInRub))
}