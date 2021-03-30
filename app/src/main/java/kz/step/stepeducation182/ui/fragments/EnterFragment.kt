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
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_enter.*
import kz.step.stepeducation182.R
import kz.step.stepeducation182.data.Student
import kz.step.stepeducation182.data.database.StudentDatabase
import kz.step.stepeducation182.data.database.entity.StudentRoomEntity
import kz.step.stepeducation182.data.network.Api
import kz.step.stepeducation182.data.network.RetrofitCreator
import kz.step.stepeducation182.data.network.ReturnData
import kz.step.stepeducation182.di.ApplicationModule
import kz.step.stepeducation182.di.DaggerApplicationComponent
import kz.step.stepeducation182.domain.GetRatesUseCase
import kz.step.stepeducation182.domain.SortStudentsUseCase
import kz.step.stepeducation182.ui.MainActivity
import kz.step.stepeducation182.ui.adapters.StudentsAdapter
import kz.step.stepeducation182.ui.base.BaseFragment
import kz.step.stepeducation182.ui.contract.EnterFragmentContract
import kz.step.stepeducation182.ui.presenter.EnterFragmentPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class EnterFragment :
    BaseFragment(),
    DatePickerDialog.OnDateSetListener,
    EnterFragmentContract.View {

    var getRatesUseCase = GetRatesUseCase()

    var enterFragmentPresenter: EnterFragmentPresenter = EnterFragmentPresenter()

    var studentsAdapter: StudentsAdapter? = null

    var students: ArrayList<Student> = ArrayList()

    @Inject lateinit var studentsSortUseCase: SortStudentsUseCase

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
        initializeDependencies()
        initializeViews()
        enterFragmentPresenter.initiateRetrieveStudents()
        initializeLinearLayoutManager()
        initiateDisplayDialogStudent()

        studentsSortUseCase.initiateSortStudents(mutableListOf<Student>())

        getRatesUseCase.execute(observerItem())

    }

    class observerItem: DisposableObserver<ReturnData>(){
        override fun onComplete() {
            Log.d("observerItem", "onComplete")
        }

        override fun onNext(t: ReturnData) {
            Log.d("observerItem", t.toString())
        }

        override fun onError(e: Throwable) {
            Log.d("observerItem", "onError")
        }

    }

    fun initializeDatabase(){
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

        studentDatabase.getStudentDao().initiateInsertStudent(student)

//        val listCall: Call<*> = jsonPlaceHolderApi.getPosts()
//
//        listCall.enqueue(object : Callback<*>() {
//            fun onResponse(
//                call: Call<*>,
//                response: Response<*>
//            ) {}
//            fun onFailure(
//                call: Call<*>,
//                t: Throwable
//            ) {}
//        })
    }

    fun initializeDependencies(){
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
            .inject(this)
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