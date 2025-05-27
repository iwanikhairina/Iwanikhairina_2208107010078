package com.example.bmi_calculator

object BMICalculator {
    fun calculateBMI(weightKg: Float, heightCm: Float): Float {
        val heightM = heightCm / 100
        return weightKg / (heightM * heightM)
    }

    fun classifyBMI(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }
    }
}
