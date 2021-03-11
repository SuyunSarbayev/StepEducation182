package kz.step.stepeducation182.ui

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
import kz.step.stepeducation182.ui.contract.EnterFragmentContract
import kz.step.stepeducation182.ui.presenter.EnterFragmentPresenter

class EnterFragment : Fragment(), EnterFragmentContract.View {

    lateinit var rootView: View

    ViewModel
    var enterFragmentPresenter: EnterFragmentPresenter
            = EnterFragmentPresenter()

    var studentsAdapter: StudentsAdapter? = null
    var name: String = "This.is values with dots. which will be replaced."

    var x = 5
    var surname = "Wick"

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
        Log.d("VARIABLE", name.replaceDots())
        if(name is String){
            Log.d("VARIABLE name", "is string")
        }
    }

    override fun initializeAdapter(students: MutableList<Student>) {
        studentsAdapter = StudentsAdapter(students)
        recyclerview_fragment_enter_students?.adapter = studentsAdapter
    }

    override fun initializeLinearLayoutManager(){
        recyclerview_fragment_enter_students?.layoutManager = LinearLayoutManager(requireContext())
    }
}