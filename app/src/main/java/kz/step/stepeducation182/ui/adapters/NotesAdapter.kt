package kz.step.stepeducation182.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation182.R
import kz.step.stepeducation182.data.Notes
import kz.step.stepeducation182.ui.viewholders.NotesViewHolder

class NotesAdapter(var notes: MutableList<Notes>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_notes, parent, false)

        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NotesViewHolder).bind(notes.get(position))
    }
}