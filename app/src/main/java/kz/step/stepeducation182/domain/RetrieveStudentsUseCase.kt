package kz.step.stepeducation182.domain

import kz.step.stepeducation182.data.Student
import kz.step.stepeducation182.data.StudentsGenerator

class RetrieveStudentsUseCase(useCasePersonsCount: UseCasePersonsCount) {
    fun provideStudents(): MutableList<Student>{
        return StudentsGenerator().initiateGenerateStudents()
    }
}