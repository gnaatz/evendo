package de.gnaatz.evendo.model

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import de.gnaatz.evendo.controller.EventLoader

class CurrentDayEvents: ViewModel() {
    private val tag = "CurrentDayEvents: ViewModel"

    private var eventList: MutableLiveData<ArrayList<Event>> = MutableLiveData()

    fun getEvents(): ArrayList<Event> {
        return eventList.value!!
    }

    fun observe(owner: LifecycleOwner, observer: Observer<ArrayList<Event>>) {
        eventList.observe(owner, observer)
    }

    fun updateEvents(events: ArrayList<Event>) {
        eventList.value = events
    }

    fun addEvent(event: Event) {
        Log.d(tag, "${eventList.value!!.size}")
        val temp = ArrayList<Event>()
        if(!eventList.value.isNullOrEmpty())
            temp.addAll(eventList.value!!)
        temp.add(event)
        eventList.value = temp
    }
}