package de.gnaatz.evendo.model

class Event(var title: String, var description: String) {
    private var todos: ArrayList<Todo> = ArrayList()

    fun addTodo(todo: Todo) {
        todos.add(todo)
        //TODO: Update remote
    }

    fun removeTodo(todo: Todo) {
        todos.remove(todo)
        //TODO: Update remote
    }
}