package com.example.alab5

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)

        textView = findViewById(R.id.textView)

        var price = intent.getIntExtra("Price_one_list", 0)
        var count = intent.getIntExtra("List_count", 0)

        var endPrice = price * count
        textView.text = "Цена печати = ${endPrice} рублей"
    }
}