package de.gnaatz.evendo.controller

import android.annotation.SuppressLint
import android.util.Log
import android.widget.CalendarView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import de.gnaatz.evendo.MainActivity
import de.gnaatz.evendo.model.CurrentDay
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.net.GetEventsRequest
import java.net.URL

class EventLoader(mainActivity: MainActivity, private var year: Int, private var month: Int, private var day: Int): CalendarView.OnDateChangeListener {
    private val tag = "EventLoader"

    companion object {
        private val tag = "EventLoader-Companion"
        @SuppressLint("UseSparseArrays")
        private val cache = HashMap<Int, ArrayList<Event>>()

        private fun addEvent(year: Int, month: Int, day: Int, event: Event) {
            val key = getKey(year, month, day)
            Log.d(tag, "created $key")
            if(cache[key].isNullOrEmpty())
                cache[key] = ArrayList()
            cache[key]!!.add(event)
        }

        private fun getEvents(year: Int, month: Int, day: Int): ArrayList<Event> {
            val key = getKey(year, month, day)
            if(cache[key].isNullOrEmpty())
                cache[key] = ArrayList()
            return cache[key]!!
        }

        private fun getKey(year: Int, month: Int, day: Int): Int {
            return day * 1000000 + month * 10000 + year
        }

        fun eventFromResponse(response: String) {
            val title = getStringValue("TITLE", response)!!
            val description = getStringValue("DESCRIPTION", response)!!
            val timeFrom = getStringValue("TIME_FROM", response)!!

            val year = getYearFromDate(timeFrom)
            val month = getMonthFromDate(timeFrom)
            val day = getDayFromDate(timeFrom)
            val hour = getHourFromDate(timeFrom)
            val minute = getMinuteFromDate(timeFrom)

            addEvent(year, month - 1, day, Event(title, description, hour, minute))
        }

        private fun getStringValue(key: String, string: String): String? {
            val keyValueRegex = "\"$key\":\\s?\"(.*?)\",".toRegex()
            return keyValueRegex.find(string)!!.groupValues[1]
        }

        private fun getNumberValue(key: String, string: String): String? {
            val keyValueRegex = "\"$key\":\\s?(.*?),".toRegex()
            return keyValueRegex.find(string)!!.groupValues[1]
        }

        private fun getYearFromDate(date: String): Int {
            return date.substring(0..3).toInt()
        }

        private fun getMonthFromDate(date: String): Int {
            return date.substring(5..6).toInt()
        }

        private fun getDayFromDate(date: String): Int {
            return date.substring(8..9).toInt()
        }

        private fun getHourFromDate(date: String): Int {
            return date.substring(11..12).toInt()
        }

        private fun getMinuteFromDate(date: String): Int {
            return date.substring(14..15).toInt()
        }
    }

    private val model = ViewModelProviders.of(mainActivity)[CurrentDay::class.java]

    init {
        Toast.makeText(mainActivity, "Getting Dates initially", Toast.LENGTH_SHORT).show()
        GetEventsRequest("info@schmuck-media.com", mainActivity).execute(URL("https://v1.api.evendo.schmuck-media.com/appointment/list"))
    }

    fun addEvent(event: Event) {
        Log.d(tag, "Year $year, Month $month, Day $day")
        addEvent(year, month, day, event)
    }

    fun getEvents(): ArrayList<Event> {
        return getEvents(year, month, day)
    }

    override fun onSelectedDayChange(calendar: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
        this.day = dayOfMonth
        this.month = month
        this.year = year

        model.updateEvents(getEvents())
    }
}