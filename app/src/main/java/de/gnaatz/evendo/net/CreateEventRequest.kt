package de.gnaatz.evendo.net

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import de.gnaatz.evendo.model.Event
import org.json.JSONObject
import java.net.URL


class CreateEventRequest(private val event: Event, private val year:Int, private val month:Int, private val day:String, private val username: String, private val context: Context): AsyncTask<URL, Int, Boolean>() {
    private val tag = "CreateEventRequest"

    override fun doInBackground(vararg p0: URL?): Boolean {
        val queue = Volley.newRequestQueue(context)
        val url = "https://v1.api.evendo.schmuck-media.com/appointment/create"

        val time = getTimeFromEvent(event, year, month, day)

        val jsonBody = JSONObject()
        jsonBody.put("username", username)
        jsonBody.put("title", event.title)
        jsonBody.put("description", event.description)
        jsonBody.put("time", time)

        val stringRequest = JsonObjectRequest(
            url, jsonBody, Response.Listener {
                Log.e(tag, "" + it.toString())
            }, Response.ErrorListener {
                Log.e(tag, "" + it.message)
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

    private fun getTimeFromEvent(event: Event, year: Int, month: Int, day: String): JSONObject {
        val rObj = JSONObject()
        rObj.put("from", "$year-${month + 1}-$day ${event.hour}:${event.minute}:00")
        rObj.put("to", "$year-${month + 1}-$day ${event.hour}:${event.minute}:00")
        return rObj
    }
}