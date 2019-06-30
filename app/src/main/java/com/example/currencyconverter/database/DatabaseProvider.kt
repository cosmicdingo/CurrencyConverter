package com.example.currencyconverter.database

import android.content.Context
import androidx.room.Room

class DatabaseProvider(context: Context) {

    val db: AppDatabase

    init {
        db = Room.databaseBuilder(context, AppDatabase::class.java, "Currency Database").build()
    }
}