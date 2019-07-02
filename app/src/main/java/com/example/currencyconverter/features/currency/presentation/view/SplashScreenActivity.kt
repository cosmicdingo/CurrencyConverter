package com.example.currencyconverter.features.currency.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.currencyconverter.features.convert.presentation.view.ConverterActivity
import com.example.currencyconverter.R
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter
import com.example.currencyconverter.features.currency.presentation.presenter.factory.PresenterFactory

class SplashScreenActivity : AppCompatActivity(), CurrencyPresenter.View {

    private var presenter: CurrencyPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        presenter = PresenterFactory.createPresenter(this)
        presenter?.onRecieve()
    }

    override fun startActivity() {
        startActivity(Intent(this, ConverterActivity::class.java))
        finish()
    }

    override fun showError() {
        Toast.makeText(this, this.getString(R.string.connection_error), Toast.LENGTH_LONG).show()
        startActivity()
        finish()
    }
}
