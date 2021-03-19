package kz.step.stepeducation182.ui.dialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_student_card.*
import kz.step.stepeducation182.R

class StudentCardDialog : DialogFragment() {

    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_student_card, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun initializeListeners(){
        button1?.setOnClickListener {
            targetFragment?.onActivityResult(101, 102, Intent())
            dismiss()
        }
    }

    fun initializeViews(){

    }
}