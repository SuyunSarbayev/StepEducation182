package kz.step.stepeducation182.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.step.stepeducation182.R
import kz.step.stepeducation182.ui.adapters.StudentsAdapter
import kz.step.stepeducation182.data.Student
import kotlinx.android.synthetic.main.fragment_enter.*
import kz.step.stepeducation182.ui.MainActivity
import kz.step.stepeducation182.ui.adapters.ViewPagerAdapter
import kz.step.stepeducation182.ui.contract.EnterFragmentContract
import kz.step.stepeducation182.ui.presenter.EnterFragmentPresenter
import kz.step.stepeducation182.ui.replaceDots

class EnterFragment : Fragment(), EnterFragmentContract.View {

    lateinit var rootView: View

    var enterFragmentPresenter: EnterFragmentPresenter = EnterFragmentPresenter()

    var studentsAdapter: StudentsAdapter? = null

    var students: ArrayList<Student> = ArrayList()

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
        enterFragmentPresenter.setView(this)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        enterFragmentPresenter.initiateRetrieveStudents()
        initializeLinearLayoutManager()
    }

    override fun initializeViews() {

    }

    override fun initializeAdapter(students: MutableList<Student>) {
        this.students = students as ArrayList<Student>
        studentsAdapter = StudentsAdapter(studentsList = this.students)
        recyclerview_fragment_enter.adapter = studentsAdapter
    }

    override fun initializeLinearLayoutManager() {
        recyclerview_fragment_enter.layoutManager = LinearLayoutManager(requireContext())
    }

    fun initiateDisplayStudents(position: Int){
        (activity as MainActivity).initiateDisplayFragment(
            FragmentStudentsDetail().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("students", this@EnterFragment.students)
                    putInt("student_position", position)
                }
            }
        )
    }
}