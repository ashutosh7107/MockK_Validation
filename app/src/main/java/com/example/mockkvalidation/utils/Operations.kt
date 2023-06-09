package com.example.mockkvalidation.utils

import kotlinx.coroutines.delay

class Operations : Arithmetic {
    override fun add(number1: String, number2: String): Int {
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        return num1 + num2
    }

    override fun subtract(number1: String, number2: String): Int {
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        return num1 - num2
    }

    override fun divide(number1: String, number2: String): Int {
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        return num1 / num2
    }

    override fun multiply(number1: String, number2: String): Int {
        val num1 = number1.toInt()
        val num2 = number2.toInt()
        return num1 * num2
    }

    suspend fun processData(): Int {
        delay(100)
        val data = "Data"
        return data.length
    }
}