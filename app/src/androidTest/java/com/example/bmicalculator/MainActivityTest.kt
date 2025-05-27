package com.example.bmi_calculator

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.bmicalculator.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testValidInputShowsBMI() {
        /* Test Case:
           Simulasikan input: 60kg, 165cm
           Klik tombol calculate
           Hasil TextView menampilkan BMI dan kategorinya
        */
        onView(withId(R.id.editWeight)).perform(typeText("60"), closeSoftKeyboard())
        onView(withId(R.id.editHeight)).perform(typeText("165"), closeSoftKeyboard())
        onView(withId(R.id.btnCalculate)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withSubstring("BMI:")))
    }

    @Test
    fun testInvalidInputShowsErrorMessage() {
        /* Test Case:
           Simulasikan input: berat kosong, tinggi 160
           Klik tombol calculate
           Hasil TextView menampilkan pesan error
        */
        onView(withId(R.id.editWeight)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.editHeight)).perform(typeText("160"), closeSoftKeyboard())
        onView(withId(R.id.btnCalculate)).perform(click())
        onView(withId(R.id.textResult)).check(matches(withText("Please enter valid inputs")))
    }
}
