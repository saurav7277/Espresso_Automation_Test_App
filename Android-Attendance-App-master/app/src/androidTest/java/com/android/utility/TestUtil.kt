package com.android.utility

import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import androidx.test.espresso.Espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import java.text.SimpleDateFormat
import java.util.*


public class TestUtil {

    public fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    /***************************************************************************************
     * Method Name : getListView
     * Arguments :  matcher -  view which you want to match
     * Returns: View - ListView corresponding to the matcher
     * Method Description : Use this method to get a listview corresponding to the matcher
     * x */
     fun getListView(matcher: Matcher<View>): View? {
        val listView: Array<ListView?> = arrayOfNulls<ListView>(1)
        onView(allOf(matcher, isEnabled(), isClickable())).check(matches(object :
            TypeSafeMatcher<View?>() {
            override fun matchesSafely(view: View?): Boolean {
                listView[0] = view as ListView?
                return true
            }

            override fun describeTo(description: Description?) {}
        }))
        return listView[0]
    }


    /***************************************************************************************
     * Method Name : getListCount
     * Arguments :  matcher -  view which you want to match
     * Returns: count - Item count of the listview
     * Method Description : Use this method to get the item count of a listview
     * x */
    fun getListCount(matcher: Matcher<View>): Int {
        val length: Int
        val view: View? = getListView(matcher)
        val adapter: Adapter = (view as AdapterView<*>?)!!.adapter
        length = adapter.getCount()
        Log.i("Size of the List", Integer.toString(length))
        return length
    }

    fun generateDateWithVarianceInDays(format: String?, variance: Int): String? {
        val sdf = SimpleDateFormat(format)
        val date = Date()
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTime(date)
        calendar.add(Calendar.DAY_OF_WEEK, variance)
        return sdf.format(calendar.time)
    }


}