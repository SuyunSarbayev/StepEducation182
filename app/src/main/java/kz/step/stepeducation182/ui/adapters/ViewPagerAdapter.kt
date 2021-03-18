package kz.step.stepeducation182.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import kz.step.stepeducation182.data.Student
import kz.step.stepeducation182.ui.fragments.StudentFragment

class ViewPagerAdapter(var students: List<Student>,
                       fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return StudentFragment().apply{
            arguments = Bundle().apply{
                putParcelable("student", students.get(position))
            }
        }
    }

    override fun getCount(): Int {
        return students.size
    }
}