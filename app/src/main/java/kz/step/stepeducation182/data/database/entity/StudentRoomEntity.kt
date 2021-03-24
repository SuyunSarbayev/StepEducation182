package kz.step.stepeducation182.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(
    entity = StudentsGroup::class,
    parentColumns = arrayOf("title"),
    childColumns = arrayOf("groupName"))))
data class StudentRoomEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var name: String = "",

    var groupName: Int = 0
)


// StudentRoomEntity table

// name |
// John
// Wayne
// Mark