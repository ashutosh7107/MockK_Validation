package com.example.mockkvalidation.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mockkvalidation.R
import com.example.mockkvalidation.utils.Operations

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val operations = Operations()
        val btn_add = findViewById<Button>(R.id.addButton)
        val btn_subtract = findViewById<Button>(R.id.differenceButton)
        val btn_multiply = findViewById<Button>(R.id.productButton)
        val btn_divide = findViewById<Button>(R.id.quotientButton)

        btn_add.setOnClickListener {
            val number1 = findViewById<TextView>(R.id.number1Text)
            val number2 = findViewById<TextView>(R.id.number2Text)
            val answerTextBox = findViewById<TextView>(R.id.answerText)
            val num1 = number1.text
            val num2 = number2.text
            val answer = operations.add(number1.text.toString(), number2.text.toString())
            answerTextBox.setText(answer.toString())
        }

        btn_subtract.setOnClickListener {
            val number1 = findViewById<TextView>(R.id.number1Text)
            val number2 = findViewById<TextView>(R.id.number1Text)
            val answerTextBox = findViewById<TextView>(R.id.answerText)
            val answer = operations.subtract(number1.text.toString(), number2.text.toString())
            answerTextBox.setText(answer.toString())
        }

        btn_multiply.setOnClickListener {
            val number1 = findViewById<TextView>(R.id.number1Text)
            val number2 = findViewById<TextView>(R.id.number1Text)
            val answerTextBox = findViewById<TextView>(R.id.answerText)
            val answer = operations.multiply(number1.text.toString(), number2.text.toString())
            answerTextBox.setText(answer.toString())
        }

        btn_divide.setOnClickListener {
            val number1 = findViewById<TextView>(R.id.number1Text)
            val number2 = findViewById<TextView>(R.id.number1Text)
            val answerTextBox = findViewById<TextView>(R.id.answerText)
            val answer = operations.divide(number1.text.toString(), number2.text.toString())
            answerTextBox.setText(answer.toString())
        }

    }
}