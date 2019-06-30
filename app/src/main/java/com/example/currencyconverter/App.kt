package com.example.currencyconverter

import android.app.Application
import android.content.Context
import com.example.currencyconverter.database.DatabaseProvider
import com.example.currencyconverter.network.RetrofitProvider

class App : Application() {

    private var retrofitProvider : RetrofitProvider? = null
    private var databaseProvider: DatabaseProvider? = null

    override fun onCreate() {
        super.onCreate()
        retrofitProvider = RetrofitProvider()
        databaseProvider = DatabaseProvider(applicationContext)
    }

    companion object {

        fun getRetrofitProvider(context: Context): RetrofitProvider? {
            return getApp(context).retrofitProvider
        }

        fun getDatabaseProvider(context: Context): DatabaseProvider? {
            return getApp(context).databaseProvider
        }

        private fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}