package de.gnaatz.evendo.controller

import android.content.Context
import android.widget.CalendarView
import android.widget.Toast

class EventLoader(private val context: Context, private var day: Int, private var month: Int, private var year: Int): CalendarView.OnDateChangeListener {

    init {
        Toast.makeText(context, "Getting Dates initially", Toast.LENGTH_SHORT).show()
    }



    override fun onSelectedDayChange(calendar: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(calendar.context, "Day changed", Toast.LENGTH_SHORT).show()
        this.day = dayOfMonth
        this.month = month
        this.year = year
    }
}