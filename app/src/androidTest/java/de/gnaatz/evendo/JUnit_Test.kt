package de.gnaatz.evendo

import de.gnaatz.evendo.controller.EventDisplay
import de.gnaatz.evendo.controller.TodoDisplay
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.model.Todo
import org.junit.Assert
import org.junit.Test
import kotlin.collections.ArrayList

class JUnit_Test {

    @Test
    fun testEvent(){
        var event = Event("testTitle", "testDescription", 23,59)

        Assert.assertEquals(event.createTodo("Test"),kotlin.Unit)
    }

    @Test
    fun testEventDisplay(){
        var events = ArrayList<Event>()
        var updateEvents = ArrayList<Event>()
        var event1 = Event("title1","description1",23,59)
        var event2 = Event("title2","description2",0,0)
        events.add(event1)
        updateEvents.add(event1)
        updateEvents.add(event2)
        var eventDisplay = EventDisplay(events)

        Assert.assertEquals(eventDisplay.itemCount, events.size)

        eventDisplay.updateData(updateEvents)
        Assert.assertEquals(eventDisplay.itemCount, 2)

    }
    /*
    @Test
    fun testEventLoader(){
        var eventLoader = EventLoader(MainActivity(),2020,6,24)
        var event = Event("title","description",23,59)
        var events = ArrayList<Event>()
        events.add(event)
        var date = Date(2020,6,24)

        Assert.assertEquals(eventLoader.addEvent(event), kotlin.Unit)
        eventLoader.addEvent(event)
        Assert.assertEquals(eventLoader.getEvents().size, events.size)

    } */

    @Test
    fun testTodoDisplay(){
        var todos = ArrayList<Todo>()
        var updateTodos = ArrayList<Todo>()
        var todo1 = Todo("title1","description1")
        var todo2 = Todo("title2","description2")
        todos.add(todo1)
        updateTodos.add(todo1)
        updateTodos.add(todo2)
        var todoDisplay = TodoDisplay(todos)

        Assert.assertEquals(todoDisplay.itemCount, todos.size)

        todoDisplay.updateData(updateTodos)
        Assert.assertEquals(todoDisplay.itemCount, 2)
    }
}