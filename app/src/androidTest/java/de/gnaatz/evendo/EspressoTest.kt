package de.gnaatz.evendo

import android.view.View
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.widget.TimePicker
import org.hamcrest.Matchers
import androidx.test.espresso.Espresso.onView
import android.widget.NumberPicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.matcher.ViewMatchers.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import java.util.*
import java.util.Calendar as Calendar


@RunWith(AndroidJUnit4::class)
@LargeTest

class EspressoTest {

        @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun createEvent() {

        var hour = 10
        var minutes = 40

        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.add_title_edit_text)).perform(typeText("Test Event Title"))
        onView(withId(R.id.description_add_event)).perform(typeText("Test Event Description"), ViewActions.closeSoftKeyboard())
        val timePicker = onView(withClassName(Matchers.equalTo(TimePicker::class.java.name)))
        timePicker.perform(setTime(hour, minutes))
        onView(withId(R.id.fab_create_event)).perform(click())
    }

    fun setTime(hour:Int, minute:Int):ViewAction {
        return object:ViewAction {
            override fun getDescription(): String {
                return "Set the passed time into the TimePicker"
            }

            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(TimePicker::class.java)
            }
            override fun perform(uiController:UiController, view:View) {
                val tp = view as TimePicker
                tp.setCurrentHour(hour)
                tp.setCurrentMinute(minute)
            }
        }
    }

    @Test
    fun changeDay() {
        var day = 1
        var month = 3
        var year = 2020

        onView(allOf(withId(R.id.calendar), hasChildCount(1))).perform(setDate(day, month, year))
    }

    fun setDate(day:Int, month:Int, year:Int):ViewAction {
        return object:ViewAction {
            override fun getDescription(): String {
                return "Set the passed date into the Calendar"
            }

            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.withId(R.id.calendar)//.also { hasChildCount(1) }
            }
            override fun perform(uiController:UiController, view:View) {
                val calendarView = view as CalendarView
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)

                val milliTime = calendar.timeInMillis

                calendarView.setDate(milliTime)
            }
        }
    }
}