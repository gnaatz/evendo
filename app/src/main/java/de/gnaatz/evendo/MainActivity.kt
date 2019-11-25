package de.gnaatz.evendo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.controller.EventLoader
import de.gnaatz.evendo.model.CurrentDay
import java.lang.ClassCastException
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var calendar: CalendarView
    private lateinit var eventsRoot: ViewGroup
    private lateinit var fab: View
    private lateinit var currentEvents: ArrayList<Event>
    private lateinit var eventLoader: EventLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        calendar = findViewById(R.id.calendar)
        eventsRoot = findViewById(R.id.events)
        fab = findViewById(R.id.fab)
        currentEvents = ArrayList()
        val date = Date(calendar.date * 1000)
        val year = date.year
        val month = date.month
        val day = date.date
        eventLoader = EventLoader(this, day, month, year)
        calendar.setOnDateChangeListener(eventLoader)
        val model = ViewModelProviders.of(this)[CurrentDay::class.java]

        fab.setOnClickListener {
            //TODO: Add Event dialog
            currentEvents.add(Event("Title", "Description"))
            model.getEvents().value = currentEvents
        }

        model.getEvents().observe(this, Observer<List<Event>>{ events ->
            eventsRoot.removeAllViews()
            for(event: Event in events) {
                val eventView = LayoutInflater.from(this).inflate(R.layout.layout_event_view, eventsRoot) as LinearLayout
                for(textView in eventView.children) {
                    try{
                        (textView as TextView).text = "Hey"
                    } catch(e: ClassCastException) {

                    }
                }
                currentEvents = events as ArrayList<Event>
            }
        })
    }


}
