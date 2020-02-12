package de.gnaatz.evendo.controller

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.util.SparseArray
import android.widget.CalendarView
import android.widget.Toast
import androidx.core.util.isEmpty
import androidx.core.util.set
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import de.gnaatz.evendo.MainActivity
import de.gnaatz.evendo.model.CurrentDay
import de.gnaatz.evendo.model.Event

class EventLoader(mainActivity: MainActivity, private var year: Int, private var month: Int, private var day: Int): CalendarView.OnDateChangeListener {
    private val tag = "EventLoader"

    companion object {
        @SuppressLint("UseSparseArrays")
        private val cache = HashMap<Int, ArrayList<Event>>()

        private fun addEvent(year: Int, month: Int, day: Int, event: Event) {
            val key = getKey(year, month, day)
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
    }

    private val model = ViewModelProviders.of(mainActivity)[CurrentDay::class.java]

    init {
        Toast.makeText(mainActivity, "Getting Dates initially", Toast.LENGTH_SHORT).show()
    }

    fun addEvent(event: Event) {
        Log.d(tag, "Year $year, Month $month, Day $day")
        addEvent(year, month, day, event)
    }

    fun getEvents(): ArrayList<Event> {
        return getEvents(year, month, day)
    }

    override fun onSelectedDayChange(calendar: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
        //Toast.makeText(calendar.context, "Day changed", Toast.LENGTH_SHORT).show()
        this.day = dayOfMonth
        this.month = month
        this.year = year

        model.updateEvents(getEvents())
    }
}