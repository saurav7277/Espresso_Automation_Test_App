package com.android.attendance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.attendance.activity.LoginActivity
import com.android.attendance.activity.MainActivity
import com.example.androidattendancesystem.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

import androidx.test.espresso.matcher.RootMatchers.withDecorView

import androidx.test.espresso.Espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

import androidx.test.espresso.Espresso.onView
import com.android.utility.ToastMatcher


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun test_adminLogin(){
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("admin")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("admin123"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_facultyLogin(){
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("faculty")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("saurav7277"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("saurav@7277"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }


}