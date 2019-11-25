package de.gnaatz.evendo

import android.app.usage.UsageEvents
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import de.gnaatz.evendo.eventing.Event
import de.gnaatz.evendo.eventing.EventLoader

class MainActivity : AppCompatActivity() {

    private lateinit var calendar: CalendarView
    private lateinit var currentEvents: List<Event>
    private lateinit var eventLoader: EventLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        calendar = findViewById(R.id.calendar)
        currentEvents = ArrayList()
        eventLoader = EventLoader(this)
        eventLoader.init()
        calendar.setOnDateChangeListener(eventLoader)
    }
}
