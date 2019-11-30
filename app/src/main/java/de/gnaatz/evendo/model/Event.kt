package de.gnaatz.evendo.model

class Event(var title: String, var description: String, var hour: Int, var minute: Int) {
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