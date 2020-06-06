package de.gnaatz.evendo.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.gnaatz.evendo.R
import de.gnaatz.evendo.util.Finals

class CreateTODO: AppCompatActivity() {
    private val tag = "CreateTODO: Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_todo)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_add_todo)
        setSupportActionBar(toolbar)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val fab = findViewById<FloatingActionButton>(R.id.fab_create_todo)
        intent.putExtra("successful", false)
        setResult(Finals.CREATE_TODO, intent)

        backButton.setOnClickListener {
            Log.d(tag, "Closed")
            finish()
        }

        fab.setOnClickListener {
            val title = findViewById<EditText>(R.id.add_title_edit_text_todo).text.toString()
            val description = findViewById<EditText>(R.id.description_add_todo).text.toString()

            intent = Intent()
            intent.putExtra("successful", true)
            intent.putExtra("title", title)
            intent.putExtra("description", description)

            setResult(Finals.CREATE_TODO, intent)
            finishActivity(Finals.CREATE_TODO)
            finish()
        }
    }

}