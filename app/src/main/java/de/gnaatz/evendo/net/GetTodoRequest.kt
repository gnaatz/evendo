package de.gnaatz.evendo.net

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import de.gnaatz.evendo.controller.EventLoader
import org.json.JSONObject
import java.net.URL

class GetTodoRequest(private val username: String, private val context: Context): AsyncTask<URL, Int, Boolean>() {
    private val tag = "GetTodoRequest"

    override fun doInBackground(vararg url: URL?): Boolean {
        val queue = Volley.newRequestQueue(context)

        val jsonBody = JSONObject()
        jsonBody.put("username", username)

        Log.d(tag, "getting todos")

        val stringRequest = object: StringRequest(
            Method.POST,
            url[0].toString(),
            Response.Listener<String> { response ->
                Log.d(tag, response)
                val todoDelimiter = "[{]([^{}]*?)?[}],".toRegex()
                val todoList: List<MatchResult> = todoDelimiter.findAll(response).toList()
                for(todo in todoList) {
                    Log.d(tag, todo.value)
                    EventLoader.eventFromResponse(todo.value)
                }
            },
            Response.ErrorListener {
                Log.e(tag, "Task Failed:\n${String(it.networkResponse.data, Charsets.UTF_8)}")
            }){
            override fun getBodyContentType(): String {
                return "application/json"
            }

            override fun getBody(): ByteArray {
                return jsonBody.toString().toByteArray()
            }
        }

        queue.add(stringRequest)
        return false
    }

}