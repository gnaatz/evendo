package de.gnaatz.evendo.model

class EventDisplayable(var title: String, var description: String, var hour: Int, var minute: Int, var collapsed: Boolean, var todos: ArrayList<Todo>) {

    companion object {
        fun fromEvent(event: Event):EventDisplayable {
            return EventDisplayable(event.title, event.description, event.hour, event.minute, true, event.todos)
        }

        fun fromEventList(events: List<Event>): List<EventDisplayable> {
            return List(events.size) {
                fromEvent(events[it])
            }
        }
    }
}