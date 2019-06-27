package com.example.currencyconverter.features.currency.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.features.currency.domain.model.Currency
import com.example.currencyconverter.features.currency.presentation.adapter.CurrencyAdapter
import com.example.currencyconverter.features.currency.presentation.presenter.CurrencyPresenter
import com.example.currencyconverter.features.currency.presentation.presenter.factory.PresenterFactory

class MainActivity : AppCompatActivity(), CurrencyPresenter.View {

    private val TAG = "MainActivity"
    private var progressBar: ProgressBar? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: CurrencyAdapter? = null

    private var presenter: CurrencyPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")
        initUI()
        showProgress()
        presenter = PresenterFactory.createPresenter(this)
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
        presenter?.onResume()
    }

    fun initUI() {

        Log.d(TAG, "initIU")
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
    }

    override fun showCurrencies(currencies: List<Currency>?) {
        adapter = CurrencyAdapter(currencies)
        recyclerView?.adapter = adapter
    }

    override fun showProgress() {
        Log.d(TAG, "showProgress")
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.INVISIBLE
    }

    override fun showError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
