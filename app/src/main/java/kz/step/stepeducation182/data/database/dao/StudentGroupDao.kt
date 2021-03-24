package kz.step.stepeducation182.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.step.stepeducation182.data.database.entity.StudentRoomEntity
import kz.step.stepeducation182.data.database.entity.StudentsGroup

@Dao
interface StudentGroupDao {

    @Insert
    fun initiateInsertStudentGroup(studentGroup: StudentsGroup)

    @Query("SELECT * FROM studentroomentity WHERE groupName IS :groupTitle")
    fun initiateGetStudentFromGroup(groupTitle: Int): StudentRoomEntity
}