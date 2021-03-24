package kz.step.stepeducation182.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.step.stepeducation182.data.database.dao.StudentDao
import kz.step.stepeducation182.data.database.dao.StudentGroupDao
import kz.step.stepeducation182.data.database.entity.StudentRoomEntity
import kz.step.stepeducation182.data.database.entity.StudentsGroup

@Database(entities = arrayOf(
    StudentsGroup::class,
    StudentRoomEntity::class), version = 5)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    abstract fun getStudentGroupDao(): StudentGroupDao

    companion object{
        fun initiateGenerateDatabase(context: Context): StudentDatabase{
            return Room.databaseBuilder(context,
                StudentDatabase::class.java,
                "studentDatabase")
                .build()
        }

        fun initiateGetStudentDao(context: Context): StudentDao {
            return initiateGenerateDatabase(context).getStudentDao()
        }
    }
}