package de.gnaatz.evendo.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.gnaatz.evendo.R
import de.gnaatz.evendo.util.Finals


class CreateEvent: AppCompatActivity() {
    private val tag = "CreateEvent: Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_event)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_add_event)
        setSupportActionBar(toolbar)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val fab = findViewById<FloatingActionButton>(R.id.fab_create_event)
        intent.putExtra("successful", false)
        setResult(Finals.CREATE_EVENT, intent)

        backButton.setOnClickListener {
            Log.d(tag, "Closed")
            finish()
        }

        fab.setOnClickListener {
            val timePicker = findViewById<TimePicker>(R.id.time_picker_add_event)

            val title = findViewById<EditText>(R.id.add_title_edit_text).text.toString()
            val description = findViewById<EditText>(R.id.description_add_event).text.toString()
            val hour = timePicker.hour
            val minute = timePicker.minute

            intent = Intent()
            intent.putExtra("successful", true)
            intent.putExtra("title", title)
            intent.putExtra("description", description)
            intent.putExtra("hour", hour)
            intent.putExtra("minute", minute)

            setResult(Finals.CREATE_EVENT, intent)
            finishActivity(Finals.CREATE_EVENT)
            finish()
        }
    }
}