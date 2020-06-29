package de.gnaatz.evendo.model

class Event(var title: String, var description: String, var hour: Int, var minute: Int) {
    var todos: ArrayList<Todo> = ArrayList()

    fun createTodo(title: String) {
        todos.add(Todo(title))
        //TODO: Update remote
    }

    fun removeTodo(todo: Todo) {
        todos.remove(todo)
        //TODO: Update remote
    }
}