package de.gnaatz.evendo.eventing

class Event(var title: String, var description: String) {
    private lateinit var todos: List<Todo>
}