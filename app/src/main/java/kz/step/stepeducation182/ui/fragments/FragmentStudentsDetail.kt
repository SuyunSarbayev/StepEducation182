package kz.step.stepeducation182.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_students_detail.*
import kz.step.stepeducation182.R
import kz.step.stepeducation182.data.Student

class FragmentStudentsDetail : Fragment() {

    var rootView: View? = null

    var students: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_students_detail,
            container,
            false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun initializeArguments(){
        arguments?.getParcelableArrayList<Student>("students")?.let {
            students = it
        }
    }

    fun initializeViewPager(){
        viewpager_fragment_students.adapter
    }
}