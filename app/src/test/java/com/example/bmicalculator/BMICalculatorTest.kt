package com.example.bmi_calculator

import org.junit.Assert.*
import org.junit.Test

class BMICalculatorTest {

    @Test
    fun testCalculateBMI() {
        /* Test Case:
           Input: weight = 70kg, height = 170cm
           Expected BMI: 24.22 (Normal)
        */
        val bmi = BMICalculator.calculateBMI(70f, 170f)
        assertEquals(24.22f, bmi, 0.01f)
    }

    @Test
    fun testClassifyBMI() {
        /* Test Case:
           Input BMI = 32
           Expected Result: "Obese"
        */
        val category = BMICalculator.classifyBMI(32f)
        assertEquals("Obese", category)
    }
}
