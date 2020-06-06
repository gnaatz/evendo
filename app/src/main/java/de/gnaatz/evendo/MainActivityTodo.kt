package de.gnaatz.evendo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.gnaatz.evendo.controller.TodoDisplay
import de.gnaatz.evendo.controller.TodoLoader
import de.gnaatz.evendo.fragment.CreateTODO
import de.gnaatz.evendo.model.CurrentDayEvents
import de.gnaatz.evendo.model.CurrentDayTodos
import de.gnaatz.evendo.model.Todo
import de.gnaatz.evendo.util.Finals
import kotlin.collections.ArrayList

class MainActivityTodo : AppCompatActivity() {
    private val tag = "MainActivityTodo"

    private lateinit var eventsButton: View
    private lateinit var fab: View
    private lateinit var model: CurrentDayTodos
    private lateinit var todoLoader: TodoLoader
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: TodoDisplay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "MainActivityTodo: onCreate()")
        setContentView(R.layout.activity_main_todo)

        eventsButton = findViewById(R.id.events)
        fab = findViewById(R.id.fab_todo)
        recyclerView = findViewById(R.id.recyclerView_todo)


        eventsButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            this.startActivity(intent)
        }

        todoLoader = TodoLoader(this)
        model = ViewModelProviders.of(this)[CurrentDayTodos::class.java]

        fab.setOnClickListener {
            val intent = Intent(this, CreateTODO::class.java)
            startActivityForResult(intent, Finals.CREATE_TODO)
        }

        model.observe(this, Observer{ todos ->
            recyclerAdapter.updateData(todos)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        val tempTodos = ArrayList<Todo>()
        tempTodos.addAll(todoLoader.getTodos2())
        recyclerAdapter = TodoDisplay(tempTodos)
        recyclerView.adapter = recyclerAdapter
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "MainActivityTodo: onStart()")

        model.updateTodos(todoLoader.getTodos2())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            Finals.CREATE_TODO -> {
                val bundle = data!!.extras
                if(bundle!!.get("successful") as Boolean) {
                    val title = bundle.get("title") as String
                    val todo = Todo(title)
                    todoLoader.addTodo2(todo)
                }
            }
        }
    }
}
