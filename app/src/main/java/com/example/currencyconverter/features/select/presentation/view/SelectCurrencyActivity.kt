package com.example.currencyconverter.features.select.presentation.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.features.currency.domain.model.info.CurrencyInfo
import com.example.currencyconverter.features.select.presentation.adapter.SelectCurrencyAdapter
import com.example.currencyconverter.features.select.presentation.presenter.SelectCurrencyPresenter
import com.example.currencyconverter.features.select.presentation.presenter.factory.SelectCurrencyPresenterFactory

class SelectCurrencyActivity : AppCompatActivity(), SelectCurrencyPresenter.View, OnSelectCurrencyListener {

    private val TAG = "SelectCurrencyActivity"
    private var recyclerView: RecyclerView? = null
    private var adapter: SelectCurrencyAdapter? = null

    private var presenter: SelectCurrencyPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_currency)

        initUI()
        presenter = SelectCurrencyPresenterFactory.createPresenter(this)
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
        presenter?.onRecieve()
    }

    fun initUI() {

        Log.d(TAG, "initIU")
        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
    }

    override fun showCurrenciesList(currencies: List<CurrencyInfo>) {
        adapter = SelectCurrencyAdapter(currencies, this)
        recyclerView?.adapter = adapter
    }

    override fun onSelectCurrency(charCode: String) {
        intent = Intent()
        intent.putExtra("char_code", charCode)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.loading_data_error), Toast.LENGTH_LONG).show()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
