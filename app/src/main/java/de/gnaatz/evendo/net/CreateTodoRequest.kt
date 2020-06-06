package de.gnaatz.evendo.net

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.model.Todo
import org.json.JSONObject
import java.net.URL


class CreateTodoRequest(private val todo: Todo, private val username: String, private val context: Context): AsyncTask<URL, Int, Boolean>() {
    private val tag = "CreateTodoRequest"

    override fun doInBackground(vararg p0: URL?): Boolean {
        val queue = Volley.newRequestQueue(context)
        val url = "https://v1.api.evendo.schmuck-media.com/todo/create"

        val jsonBody = JSONObject()
        jsonBody.put("username", username)
        jsonBody.put("title", todo.title)
        jsonBody.put("description", todo.description)

        val stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                
            },
            Response.ErrorListener {

            })

        queue.add(stringRequest)
        return false
    }

    override fun onPostExecute(successful: Boolean?) {
        if (!successful!!) {
            Log.e(tag, "Task Failed")
        }
        super.onPostExecute(successful)
    }
}