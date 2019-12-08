package de.gnaatz.evendo.net

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import de.gnaatz.evendo.model.Event
import org.json.JSONObject
import java.net.URL


class CreateEventRequest(private val event: Event, private val username: String, private val context: Context): AsyncTask<URL, Int, Boolean>() {
    private val tag = "CreateEventRequest"

    override fun doInBackground(vararg p0: URL?): Boolean {
        val queue = Volley.newRequestQueue(context)
        val url = "https://v1.api.evendo.schmuck-media.com/appointment/create"

        val time = getTimeFromEvent(event)

        val jsonBody = JSONObject()
        jsonBody.put("username", username)
        jsonBody.put("title", event.title)
        jsonBody.put("description", event.description)
        jsonBody.put("time", time)

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
        if(!successful!!) {
            Log.e(tag, "Task Failed")
        }
        super.onPostExecute(successful)
    }

    private fun getTimeFromEvent(event: Event): JSONObject {
        val rObj = JSONObject()
        rObj.put("from", "2019-12-11 ${event.hour}:${event.minute}:00")
        rObj.put("to", "2019-12-11 ${event.hour}:${event.minute}:00")
        return rObj
    }
}