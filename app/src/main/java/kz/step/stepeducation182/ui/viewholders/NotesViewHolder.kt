package kz.step.stepeducation182.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation182.data.Notes
import kotlinx.android.synthetic.main.viewholder_notes.*
import kotlinx.android.synthetic.main.viewholder_notes.view.*

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(note: Notes){
        itemView.viewholder_notes_title.text = note.title
        itemView.viewholder_notes_description.text = note.description
        itemView.viewholder_notes_date.text = note.date
        itemView.viewholder_notes_photo.setImageBitmap(note.photo)
    }
}