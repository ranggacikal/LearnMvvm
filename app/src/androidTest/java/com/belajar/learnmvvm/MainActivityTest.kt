package com.belajar.learnmvvm

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    private val expectedVolume = "6.0"

    private val width = "1.0"
    private val height = "2.0"
    private val length = "3.0"

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun calculateVolume(){
        //isi input edit text
        onView(withId(R.id.edt_length)).perform(typeText(length), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(width), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(height), closeSoftKeyboard())

        onView(withId(R.id.btn_calculate)).check(matches(isDisplayed()))

        //klik button
        onView(withId(R.id.btn_calculate)).perform(click())

        //cek texview
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))

        //tampilkan hasil
        onView(withId(R.id.tv_result)).check(matches(withText(expectedVolume)))
    }
}