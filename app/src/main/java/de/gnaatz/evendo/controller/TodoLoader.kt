package de.gnaatz.evendo.controller

import android.annotation.SuppressLint
import de.gnaatz.evendo.MainActivityTodo
import de.gnaatz.evendo.model.Todo

class TodoLoader(mainActivity: MainActivityTodo) {
    private val tag = "TodoLoader"

    companion object {
        private val tag = "TodoLoader-Companion"
        @SuppressLint("UseSparseArrays")
        private val cache = ArrayList<Todo>()

        private fun addTodo(todo: Todo) {
            cache.add(todo)

        }

        private fun getTodos(): ArrayList<Todo> {
            return cache
        }

        fun todoFromResponse(response: String) {
            val title = getStringValue("TITLE", response)!!

            addTodo(Todo(title))
        }

        private fun getStringValue(key: String, string: String): String? {
            val keyValueRegex = "\"$key\":\\s?\"(.*?)\",".toRegex()
            return keyValueRegex.find(string)!!.groupValues[1]
        }

        private fun getNumberValue(key: String, string: String): String? {
            val keyValueRegex = "\"$key\":\\s?(.*?),".toRegex()
            return keyValueRegex.find(string)!!.groupValues[1]
        }
    }

    /*init {
        Toast.makeText(mainActivityTodo, "Getting Todos initially", Toast.LENGTH_SHORT).show()
        GetTodosRequest("info@schmuck-media.com", mainActivityTodo).execute(URL("https://v1.api.evendo.schmuck-media.com/appointment/list"))
    }*/

    fun addTodo2(todo: Todo) {
        addTodo(todo)
    }

    fun getTodos2(): ArrayList<Todo> {
        return getTodos()
    }
}