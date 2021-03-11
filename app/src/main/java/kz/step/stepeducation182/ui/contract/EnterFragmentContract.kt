package kz.step.stepeducation182.ui.contract

import kz.step.stepeducation182.data.Student

class EnterFragmentContract {

    interface View{
        fun initializeViews()

        fun initializeAdapter(students: MutableList<Student>)

        fun initializeLinearLayoutManager()
    }

    interface Presenter{
        fun setView(view: View)

        fun initiateRetrieveStudents()
    }
}