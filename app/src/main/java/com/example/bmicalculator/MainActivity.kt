package com.example.bmi_calculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightInput = findViewById<EditText>(R.id.editWeight)
        val heightInput = findViewById<EditText>(R.id.editHeight)
        val resultText = findViewById<TextView>(R.id.textResult)
        val buttonCalc = findViewById<Button>(R.id.btnCalculate)

        buttonCalc.setOnClickListener {
            val weight = weightInput.text.toString().toFloatOrNull()
            val height = heightInput.text.toString().toFloatOrNull()
            if (weight != null && height != null) {
                val bmi = BMICalculator.calculateBMI(weight, height)
                val category = BMICalculator.classifyBMI(bmi)
                resultText.text = "BMI: %.2f (%s)".format(bmi, category)
            } else {
                resultText.text = "Please enter valid inputs"
            }
        }
    }
}
