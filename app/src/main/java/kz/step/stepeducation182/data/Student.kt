package kz.step.stepeducation182.data

import android.os.Parcel
import android.os.Parcelable

class Student() : Parcelable{
    var name: String? = ""
    var surname: String? = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        surname = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}