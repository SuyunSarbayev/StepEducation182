package kz.step.stepeducation182.ui.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kz.step.stepeducation182.R
import kz.step.stepeducation182.ui.adapters.StudentsAdapter
import kz.step.stepeducation182.data.Student
import kotlinx.android.synthetic.main.fragment_enter.*
import kz.step.stepeducation182.data.database.StudentDatabase
import kz.step.stepeducation182.data.database.entity.StudentRoomEntity
import kz.step.stepeducation182.ui.MainActivity
import kz.step.stepeducation182.ui.base.BaseFragment
import kz.step.stepeducation182.ui.contract.EnterFragmentContract
import kz.step.stepeducation182.ui.presenter.EnterFragmentPresenter

class EnterFragment :
    BaseFragment(),
    DatePickerDialog.OnDateSetListener,
    EnterFragmentContract.View {

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
        super.onCreateView(inflater, container, savedInstanceState)
        enterFragmentPresenter.setView(this)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        enterFragmentPresenter.initiateRetrieveStudents()
        initializeLinearLayoutManager()
        initiateDisplayDialogStudent()

        var student: StudentRoomEntity = StudentRoomEntity()
            .apply {
            name = "Mark"
            groupName = 0
        }

        var studentDatabase: StudentDatabase =
            Room.databaseBuilder(requireContext(),
            StudentDatabase::class.java,
            "studentDatabase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

//        studentDatabase
//            .getStudentGroupDao()
//            .initiateInsertStudentGroup(StudentsGroup().apply {
//                title = 0
//            })

        studentDatabase.getStudentDao().initiateInsertStudent(student)

        Log.d("DATA", studentDatabase
            .getStudentGroupDao()
            .initiateGetStudentFromGroup(0).toString())
    }

    override fun initializeLayout(): Int {
        return R.layout.fragment_enter
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun initiateDisplayDialogStudent(){
        var datePicker = DatePickerDialog(requireContext())
        datePicker.show()
//        var fragmentManager = activity?.supportFragmentManager
//        var studentCardDialog = StudentCardDialog().apply {
//            arguments = Bundle().apply {
//                this.putInt("Age", 15)
//            }
//        }
//        studentCardDialog.setTargetFragment(this, kz_step_stepeducation182_STUDENT_DIALOG)
//        studentCardDialog.show(fragmentManager!!, StudentCardDialog::class.java.name)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun initiateDisplayAlert(){
        AlertDialog.Builder(requireContext())
            .setTitle("This is alert title")
            .setMessage("This is alert message")
            .setIcon(R.drawable.ic_baseline_add_circle_24)
//            .setNeutralButton("This is neutral", object: DialogInterface.OnClickListener{
//                override fun onClick(p0: DialogInterface?, p1: Int) {
//                    p0?.dismiss()
//                }
//
//            })
            .setPositiveButton("Ok", object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })
            .setNegativeButton("Cancel", object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })
            .create()
            .show()
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

    companion object{
        const val kz_step_stepeducation182_STUDENT_DIALOG = 101
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

    }
}