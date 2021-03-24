package kz.step.stepeducation182.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StudentsGroup {
    var id: Int = 0

    @PrimaryKey
    var title: Int = 0
}