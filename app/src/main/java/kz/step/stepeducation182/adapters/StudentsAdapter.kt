package kz.step.stepeducation182.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation182.R
import kz.step.stepeducation182.data.Student
import kz.step.stepeducation182.viewholders.StudentsViewHolder

class StudentsAdapter(
    var studentsList: MutableList<Student>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        Log.d("RecyclerView", "onCreateViewHolder")
        var itemView: View =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.viewholder_student,
                    parent,
                    false)

        return StudentsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        Log.d("RecyclerView", "onBindViewHolder")
        (holder as StudentsViewHolder).bind(studentsList.get(position))
    }
}