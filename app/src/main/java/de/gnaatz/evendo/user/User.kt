package de.gnaatz.evendo.user

import de.gnaatz.evendo.model.Todo

class User(var name: String) {
    lateinit var todos: List<Todo>
    lateinit var mail: String
}