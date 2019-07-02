package com.example.currencyconverter.features.convert.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.currencyconverter.R
import com.example.currencyconverter.extension.format
import com.example.currencyconverter.features.convert.presentation.presenter.ConvertCurrencyPresenter
import com.example.currencyconverter.features.convert.presentation.presenter.factory.ConvertCurrencyPresenterFactory
import com.example.currencyconverter.features.select.presentation.view.SelectCurrencyActivity
import kotlinx.android.synthetic.main.activity_converter.*
import java.math.BigDecimal

class ConverterActivity : AppCompatActivity(), ConvertCurrencyPresenter.View {

    private var presenter: ConvertCurrencyPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        presenter = ConvertCurrencyPresenterFactory.createPresenter(this)
        initUI()
    }

    fun initUI() {

        btnSelectCurrencyLeft.setOnClickListener {
            startActivityForResult(
                Intent(this@ConverterActivity, SelectCurrencyActivity::class.java),
                1
            )
        }

        btnSelectCurrencyRight.setOnClickListener {
            startActivityForResult(
                Intent(this@ConverterActivity, SelectCurrencyActivity::class.java),
                2
            )
        }

        editTextValueLeft.setOnClickListener {
            if (!(editTextValueLeft.text.toString().equals(""))) {

                presenter?.convertCurrencies(
                    "left",
                    editTextValueLeft.text.toString().toDouble(),
                    btnSelectCurrencyLeft.text.toString(),
                    btnSelectCurrencyRight.text.toString()
                )
            }
        }

        editTextValueRight.setOnClickListener {

            if (!(editTextValueRight.text.toString().equals(""))) {
                presenter?.convertCurrencies(
                    position = "right",
                    value = editTextValueRight.text.toString().toDouble(),
                    charCodeIn = btnSelectCurrencyRight.text.toString(),
                    charCodeOut = btnSelectCurrencyLeft.text.toString()
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        when (requestCode) {
            1 -> btnSelectCurrencyLeft.text = data.getStringExtra("char_code")
            2 -> btnSelectCurrencyRight.text = data.getStringExtra("char_code")
        }
    }

    override fun showAnswer(position: String, answer: BigDecimal) {
        when (position) {
            "left" -> editTextValueRight.setText(answer.format())
            "right" -> editTextValueLeft.setText(answer.format())
        }

    }

    override fun showError() = Toast.makeText(this, getString(R.string.not_find), Toast.LENGTH_SHORT).show()
}
