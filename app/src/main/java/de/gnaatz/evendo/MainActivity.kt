package de.gnaatz.evendo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
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
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var calendar: CalendarView
    private lateinit var eventsRoot: ViewGroup
    private lateinit var currentEvents: List<Event>
    private lateinit var eventLoader: EventLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        calendar = findViewById(R.id.calendar)
        eventsRoot = findViewById(R.id.events)
        currentEvents = ArrayList()
        eventLoader = EventLoader(this)
        calendar.setOnDateChangeListener(eventLoader)

        val model = ViewModelProviders.of(this)[CurrentDay::class.java]
        model.getEvents().observe(this, Observer<List<Event>>{ events ->
            for(event: Event in events) {
                val eventView = LayoutInflater.from(this).inflate(R.layout.layout_event_view, eventsRoot) as LinearLayout
                for(textView in eventView.children) {
                    (textView as TextView).text = "Hey"
                }
            }
        })
    }


}
