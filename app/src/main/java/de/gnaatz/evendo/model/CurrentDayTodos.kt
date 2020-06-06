package de.gnaatz.evendo.model

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class CurrentDayTodos: ViewModel() {
    private val tag = "CurrentDayTodos: ViewModel"

    private var todoList: MutableLiveData<ArrayList<Todo>> = MutableLiveData()

    fun getTodos(): ArrayList<Todo> {
        return todoList.value!!
    }

    fun observe(owner: LifecycleOwner, observer: Observer<ArrayList<Todo>>) {
        todoList.observe(owner, observer)
    }

    fun updateTodos(todos: ArrayList<Todo>) {
        todoList.value = todos
    }

    fun addTodo(todo: Todo) {
        Log.d(tag, "${todoList.value!!.size}")
        val temp = ArrayList<Todo>()
        if(!todoList.value.isNullOrEmpty())
            temp.addAll(todoList.value!!)
        temp.add(todo)
        todoList.value = temp
    }
}