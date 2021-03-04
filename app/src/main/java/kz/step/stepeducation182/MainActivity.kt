package kz.step.stepeducation182

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    var fragmentContainer: FrameLayout? = null

    var currentFragment: Fragment? = null

    var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "onCreate")
        setContentView(R.layout.activity_main)
        initializeViews()
        if (currentFragment == null) {
            initiateDisplayFragment(EnterFragment())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "onStart")
        Log.e("ERROR", "onStart")
        Log.i("INFORMATION", "onStart")
        Log.w("WARNING", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LIFECYCLE", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("LIFECYCLE", "onRestoreInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "onDestroy")
    }

    fun initializeViews() {
        fragmentContainer = findViewById(R.id.framelayout_activity_main_fragment_container)
    }

    fun initiateDisplayFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager

        currentFragment?.run {
            fragmentManager
                ?.beginTransaction()
                ?.hide(currentFragment!!)
        }
        fragmentManager
            ?.beginTransaction()
            ?.add(R.id.framelayout_activity_main_fragment_container, fragment)
            ?.commit()
        currentFragment = fragment
    }
}