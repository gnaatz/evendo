package de.gnaatz.evendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.gnaatz.evendo.controller.EventDisplay
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.controller.EventLoader
import de.gnaatz.evendo.fragment.CreateEvent
import de.gnaatz.evendo.model.CurrentDay
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.ClassCastException
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    private lateinit var calendarView: CalendarView
    private lateinit var fab: View
    private lateinit var eventLoader: EventLoader
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: EventDisplay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        calendarView = findViewById(R.id.calendar)
        fab = findViewById(R.id.fab)
        val dateLong = calendarView.date
        val date = Date(dateLong)
        val calendar = Calendar.getInstance()
        calendar.time = date

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        eventLoader = EventLoader(this, day, month, year)
        calendarView.setOnDateChangeListener(eventLoader)
        val model = ViewModelProviders.of(this)[CurrentDay::class.java]

        model.updateEvents(ArrayList())

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = EventDisplay(model.getEvents())
        recyclerView.adapter = recyclerAdapter

        fab.setOnClickListener {
            val intent = Intent(this, CreateEvent::class.java)
            startActivity(intent)

            /*var event = Event("Title", "Description")
            model.addEvent(event)
            eventLoader.addEvent(event)*/
        }

        model.observe(this, Observer{ events ->
            recyclerAdapter.updateData(events)
        })
    }
}
