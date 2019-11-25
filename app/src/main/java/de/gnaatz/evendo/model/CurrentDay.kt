package de.gnaatz.evendo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrentDay: ViewModel() {
    var eventList: MutableLiveData<ArrayList<Event>> = MutableLiveData()

    fun getEvents(): MutableLiveData<ArrayList<Event>> {
        return eventList
    }
}