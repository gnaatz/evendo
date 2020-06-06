package de.gnaatz.evendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.gnaatz.evendo.controller.EventDisplay
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.controller.EventLoader
import de.gnaatz.evendo.activities.CreateEvent
import de.gnaatz.evendo.model.CurrentDay
import de.gnaatz.evendo.util.Finals
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    private lateinit var calendarView: CalendarView
    private lateinit var fab: View
    private lateinit var model: CurrentDay
    private lateinit var eventLoader: EventLoader
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: EventDisplay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "MainActivity: onCreate()")
        setContentView(R.layout.activity_main)

        calendarView = findViewById(R.id.calendar)
        fab = findViewById(R.id.fab)
        recyclerView = findViewById(R.id.recyclerView)

        val dateLong = calendarView.date
        val date = Date(dateLong)
        val calendar = Calendar.getInstance()
        calendar.time = date

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        eventLoader = EventLoader(this, year, month, day)
        model = ViewModelProviders.of(this)[CurrentDay::class.java]

        calendarView.setOnDateChangeListener(eventLoader)

        fab.setOnClickListener {
            val intent = Intent(this, CreateEvent::class.java)
            startActivityForResult(intent, Finals.CREATE_EVENT)
        }

        model.observe(this, Observer{ events ->
            recyclerAdapter.updateData(events)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        val tempEvents = ArrayList<Event>()
        tempEvents.addAll(eventLoader.getEvents())
        recyclerAdapter = EventDisplay(tempEvents)
        recyclerView.adapter = recyclerAdapter
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "MainActivity: onStart()")
        model.updateEvents(eventLoader.getEvents())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            Finals.CREATE_EVENT -> {
                val bundle = data!!.extras
                if(bundle!!.get("successful") as Boolean) {
                    val title = bundle.get("title") as String
                    val description = bundle.get("description") as String
                    val hour = bundle.get("hour") as Int
                    val minute = bundle.get("minute") as Int
                    val event = Event(title, description, hour, minute)
                    eventLoader.addEvent(event)
                }
            }
        }
    }

}
