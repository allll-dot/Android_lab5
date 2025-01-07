package com.example.alab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var buttonOk: Button
    private lateinit var editTextCount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        buttonOk = findViewById(R.id.button3)
        editTextCount = findViewById(R.id.editTextNumber)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            radioButton1.isSelected = checkedId == radioButton1.id
            radioButton2.isSelected = checkedId == radioButton2.id
            radioButton3.isSelected = checkedId == radioButton3.id
        }

        buttonOk.setOnClickListener {_ ->
            if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Выберите цену", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (editTextCount.text.isEmpty()) {
                editTextCount.error = "Введите количество"
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)

            when {
            radioButton1.isChecked->intent.putExtra("Price_one_list",10)
            radioButton2.isChecked->intent.putExtra("Price_one_list",30)
            radioButton3.isChecked->intent.putExtra("Price_one_list",100)
            }

            intent.putExtra("List_count", editTextCount.text.toString().toInt())
            startActivity(intent)
        }
    }
}