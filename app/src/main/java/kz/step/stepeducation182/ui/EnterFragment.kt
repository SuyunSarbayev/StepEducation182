package kz.step.stepeducation182.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation182.R
import kz.step.stepeducation182.adapters.StudentsAdapter
import kz.step.stepeducation182.data.Student

class EnterFragment : Fragment() {

    lateinit var rootView: View

    var students: RecyclerView? = null
    var studentsAdapter: StudentsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext())
                .inflate(
                    R.layout.fragment_enter,
                    container,
                    false
                )
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeAdapter()
        initializeLinearLayoutManager()
    }

    fun initializeViews() {
        students = rootView.findViewById(R.id.recyclerview_fragment_enter_students)
    }

    fun initializeAdapter() {
        studentsAdapter = StudentsAdapter(mutableListOf<Student>(
            Student().apply {
                name = "John"
                surname = "Wick"
            },
            Student().apply {
                name = "Ellen"
                surname = "Page"
            },
            Student().apply {
                name = "Vasya"
                surname = "Pipkin"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            },
            Student().apply {
                name = "Peter"
                surname = "Jackson"
            }
        ))
        students?.adapter = studentsAdapter
    }

    fun initializeLinearLayoutManager(){
        students?.layoutManager = LinearLayoutManager(requireContext())
    }
}