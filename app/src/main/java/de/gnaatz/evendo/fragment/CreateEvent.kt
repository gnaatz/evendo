package de.gnaatz.evendo.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.gnaatz.evendo.R

class CreateEvent: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_event)
    }
}