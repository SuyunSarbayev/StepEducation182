package kz.step.stepeducation182.data.database.dao

import androidx.room.*
import kz.step.stepeducation182.data.database.entity.StudentRoomEntity

@Dao
interface StudentDao {

    // INSERT student into studentroomentity
    @Insert
    fun initiateInsertStudent(student: StudentRoomEntity)

    // INSERT students into studentroomentity
    @Insert
    fun initiateInsertStudents(students: List<StudentRoomEntity>)

    // DELETE FROM students WHERE student.primaryKey == student.id
    @Delete
    fun initiateDeleteStudent(student: StudentRoomEntity)

    @Query("SELECT * FROM studentroomentity")
    fun initiageGetStudents(): List<StudentRoomEntity>

    @Update
    fun initiateUpdateStudent(student: StudentRoomEntity)
}