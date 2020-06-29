package de.gnaatz.evendo.controller

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import de.gnaatz.evendo.R
import de.gnaatz.evendo.model.Event
import de.gnaatz.evendo.model.EventDisplayable

class EventDisplay(private var data: ArrayList<EventDisplayable>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val tag = "EventDisplay: Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(tag, "Adapter created")
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_event_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(data, position)
    }

    fun updateData(_data: ArrayList<EventDisplayable>) {
        data.clear()
        notifyDataSetChanged()
        data.addAll(_data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tag = "ViewHolder"

        private var title = (itemView as LinearLayout).children.toList()[0] as TextView
        private var text = (itemView as LinearLayout).children.toList()[1] as TextView
        private var todos = (itemView as LinearLayout).children.toList()[2] as TextView
        private var time = (itemView as LinearLayout).children.toList()[3] as TextView

        @SuppressLint("SetTextI18n")
        fun bind(data: ArrayList<EventDisplayable>, position: Int) {
            Log.d(tag, "binding position $position")
            title.text = data[position].title
            text.text = data[position].description
            time.text = "${data[position].hour}:${data[position].minute}"
            todos.text = "${data[position].todos.size}"

        }
    }
}