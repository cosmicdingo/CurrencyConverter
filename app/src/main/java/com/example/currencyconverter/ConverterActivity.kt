package com.example.currencyconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.currencyconverter.features.select.presentation.view.SelectCurrencyActivity

class ConverterActivity : AppCompatActivity() {

    //private var etEnterValueLeft: EditText? = null
    //private var etEnterValueRight: EditText? = null
    //private var imageView: ImageView? = null
    //private var btnSelectCurrencyLeft: Button? = null
    //private var btnSelectCurrencyRight: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        initUI()
    }

    fun initUI() {

        val etEnterValueLeft: EditText = findViewById(R.id.editTextValueLeft)
        val etEnterValueRight: EditText = findViewById(R.id.editTextValueRight)
        val imageView: ImageView = findViewById(R.id.imageViewConvert)
        val btnSelectCurrencyLeft: Button = findViewById(R.id.btnSelectCurrencyLeft)
        val btnSelectCurrencyRight: Button = findViewById(R.id.btnSelectCurrencyRight)

        btnSelectCurrencyLeft.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@ConverterActivity, SelectCurrencyActivity::class.java))
            }
        })
    }
}
