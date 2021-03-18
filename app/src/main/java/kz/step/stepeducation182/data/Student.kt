package kz.step.stepeducation182.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Student : Parcelable{
    var name: String = ""
    var surname: String = ""
}