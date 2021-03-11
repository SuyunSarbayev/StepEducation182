package kz.step.stepeducation182.data

class StudentsGenerator {
    fun initiateGenerateStudents(): MutableList<Student>{
        return mutableListOf<Student>(
            Student().apply {
                name = "John"
                surname = "Wick"
            },
            Student().apply {
                name = "John"
                surname = "Wick"
            },
            Student().apply {
                name = "John"
                surname = "Wick"
            },
            Student().apply {
                name = "John"
                surname = "Wick"
            },
            Student().apply {
                name = "John"
                surname = "Wick"
            }
        )
    }
}