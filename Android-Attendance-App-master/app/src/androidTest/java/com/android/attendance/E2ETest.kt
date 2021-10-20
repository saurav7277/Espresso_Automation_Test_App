package com.android.attendance
import android.widget.DatePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.attendance.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.android.utility.TestUtil
import com.android.utility.ToastMatcher
import org.hamcrest.CoreMatchers.*
import com.example.androidattendancesystem.R
import org.junit.Assert
import androidx.test.espresso.contrib.PickerActions

import org.hamcrest.Matchers

import androidx.test.espresso.matcher.ViewMatchers.withClassName

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers


@RunWith(AndroidJUnit4::class)
class E2ETest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /********
     * Scenario-1
     */
    @Test
    fun test_scenario1(){
        onView(withText("WELCOME TO"))
            .check(matches(isDisplayed()))
        onView(withId(R.id.buttonstart)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonstart)).check(matches(isClickable()))
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("admin")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("admin123"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
    }
    /********
     * Scenario-2,6
     */
    @Test
    fun test_scenario2_6() {
        val firstName = TestUtil().getRandomString(5)
        val lastName = TestUtil().getRandomString(5)
        val yearArray= arrayOf("SE","TE","BE")
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("admin")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("admin123"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonViewstudent)).perform(click())
        onView(withId(R.id.spinnerbranchView)).perform(click())
        onView(withText("cse")).perform(click())
        onView(withId(R.id.spinneryearView)).perform(click())
        onView(withText("TE")).perform(click())
        onView(withId(R.id.submitButton)).perform(click())
        var prevStudentCount = TestUtil().getListCount(withId(R.id.listview))
        println("No of student before student addition: $prevStudentCount")
        Espresso.pressBack()
        Espresso.pressBack()
        onView(withId(R.id.buttonaddstudent)).perform(click())
        onView(withText("Registration")).check(matches(isDisplayed()))
        onView(withId(R.id.editTextFirstName)).perform(typeText(firstName), closeSoftKeyboard())
        onView(withId(R.id.editTextLastName)).perform(typeText(lastName), closeSoftKeyboard())
        onView(withId(R.id.editTextPhone)).perform(typeText("8010597642"), closeSoftKeyboard())
        onView(withId(R.id.editTextaddr)).perform(typeText("Bihar"), closeSoftKeyboard())
        onView(withId(R.id.spinnerdept)).perform(click())
        onView(withText("cse")).perform(click())
        onView(withId(R.id.spinneryear)).perform(click())
        for(year in yearArray){
            onView(allOf(withClassName(`is`("android.widget.CheckedTextView")), withText(year))).check(
                matches(isDisplayed()))
        }
        onView(withText("TE")).perform(click())
        onView(withId(R.id.RegisterButton)).perform(click())
        onView(withText("student added successfully")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
        onView(withId(R.id.buttonViewstudent)).perform(click())
        onView(withId(R.id.spinnerbranchView)).perform(click())
        onView(withText("cse")).perform(click())
        onView(withId(R.id.spinneryearView)).perform(click())
        onView(withText("TE")).perform(click())
        onView(withId(R.id.submitButton)).perform(click())
        var afterStudentCount = TestUtil().getListCount(withId(R.id.listview))
        println("No of student after student addition: $afterStudentCount")
        Assert.assertTrue("After student count not equla to oprevious plus one", afterStudentCount==prevStudentCount+1)
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(equalTo("$firstName,$lastName")))).check(
            matches(isCompletelyDisplayed()))

    }

    /********
     * Scenario-3,7
     */
    @Test
    fun test_scenario3_7() {
        val firstName = TestUtil().getRandomString(5)
        val lastName = TestUtil().getRandomString(5)
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("admin")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("admin123"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonaddfaculty)).perform(click())
        onView(withId(R.id.editTextFirstName)).perform(typeText(firstName), closeSoftKeyboard())
        onView(withId(R.id.editTextLastName)).perform(typeText(lastName), closeSoftKeyboard())
        onView(withId(R.id.editTextPhone)).perform(typeText("80105976542"), closeSoftKeyboard())
        onView(withId(R.id.editTextaddr)).perform(typeText("Delhi"), closeSoftKeyboard())
        onView(withId(R.id.editTextUserName)).perform(typeText("$firstName $lastName 123"), closeSoftKeyboard())
        onView(withId(R.id.editTextPassword)).perform(typeText("$firstName$lastName@12345"), closeSoftKeyboard())
        onView(withId(R.id.RegisterButton)).perform(click())
        onView(withText("Faculty added successfully")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
        onView(withId(com.example.androidattendancesystem.R.id.buttonviewfaculty)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(equalTo(" FirstName: "+firstName+"\n"+"Lastname:"+lastName)))).check(
            matches(isCompletelyDisplayed()))

        Espresso.pressBack()
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).perform(click())
        onView(withId(R.id.buttonstart)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("faculty")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("$firstName $lastName 123"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("$firstName$lastName@12345"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.viewTotalAttendanceButton)).check(matches(isDisplayed()))

    }

    /********
     * Scenario-4,5
     */
    @Test
    fun test_scenario4_5(){
        val firstName = TestUtil().getRandomString(5)
        val lastName = TestUtil().getRandomString(5)
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("admin")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("admin"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("admin123"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonaddstudent)).perform(click())
        onView(withText("Registration")).check(matches(isDisplayed()))
        onView(withId(R.id.editTextFirstName)).perform(typeText(firstName), closeSoftKeyboard())
        onView(withId(R.id.editTextLastName)).perform(typeText(lastName), closeSoftKeyboard())
        onView(withId(R.id.editTextPhone)).perform(typeText("8010597642"), closeSoftKeyboard())
        onView(withId(R.id.editTextaddr)).perform(typeText("Bihar"), closeSoftKeyboard())
        onView(withId(R.id.spinnerdept)).perform(click())
        onView(withText("cse")).perform(click())
        onView(withId(R.id.spinneryear)).perform(click())
        onView(withText("TE")).perform(click())
        onView(withId(R.id.RegisterButton)).perform(click())
        onView(withText("student added successfully")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
        onView(withId(R.id.buttonlogout)).perform(click())
        onView(withId(R.id.buttonstart)).perform(click())
        onView(withText("Login here..")).check(matches(isDisplayed()))
        onView(withId(R.id.spinnerloginas)).perform(click())
        onView(withText("faculty")).perform(click())
        onView(withId(R.id.editTextusername)).perform(typeText("saurav7277"), closeSoftKeyboard())
        onView(withId(R.id.editTextpassword)).perform(typeText("saurav@7277"), closeSoftKeyboard())
        onView(withId(R.id.buttonlogin)).perform(click())
        onView(withText("Login successful")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        onView(withId(R.id.viewTotalAttendanceButton)).check(matches(isDisplayed()))
        onView(withId(R.id.spinneryear)).perform(click())
        onView(withText("TE")).perform(click())
        onView(withId(R.id.spinnerSE)).perform(click())
        onView(withText("DS")).perform(click())
        onView(withId(R.id.DateImageButton)).perform(click())
        onView(withText("OK")).inRoot(RootMatchers.isDialog()).check(matches(isDisplayed())).perform(
            click())
        onView(withId(R.id.buttonsubmit)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(equalTo("qq,qq")))).check(
            matches(isCompletelyDisplayed())).perform(click())
        onView(withId(R.id.PresentradioButton)).check(matches(isDisplayed())).perform(click())
        onView(withId((R.id.attendanceSubmitButton))).check(matches(isDisplayed())).perform(click())
        Espresso.pressBack()
        onView(withId(R.id.viewAttendancebutton)).check(matches(isDisplayed())).perform(click())
        onView(allOf(withId(R.id.labelAttendance), withText(containsString("qq,qq                  P")))).check(
            matches(isDisplayed()))
    }
}