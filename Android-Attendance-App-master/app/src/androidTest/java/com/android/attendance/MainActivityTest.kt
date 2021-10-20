package com.android.attendance

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.attendance.activity.MainActivity
import com.example.androidattendancesystem.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_launchApp() {
        Espresso.onView(ViewMatchers.withText("WELCOME TO"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_startBtnVerification(){
        onView(withId(R.id.buttonstart)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonstart)).check(matches(isClickable()))
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
    }


}