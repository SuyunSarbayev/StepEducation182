package kz.step.stepeducation182.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_student.*
import kz.step.stepeducation182.R
import kz.step.stepeducation182.data.Student

class StudentFragment : Fragment() {

    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textview_fragment_student_name.text = arguments?.getParcelable<Student>(
            "student"
        )?.name ?: "Empty name"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_student,
            container, false)

        return rootView
    }
}