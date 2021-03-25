package kz.step.stepeducation182.domain

import android.util.Log
import kz.step.stepeducation182.data.Student

class SortStudentsUseCase(retrieveStudentsUseCase: RetrieveStudentsUseCase) {

    fun initiateSortStudents(students: MutableList<Student>){
        Log.d("Data", "message")
    }
}