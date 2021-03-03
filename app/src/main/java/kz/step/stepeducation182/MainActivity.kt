package kz.step.stepeducation182

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var showWelcome: Button? = null
    var welcomeMessage: TextView? = null

    var peopleCount = 0
    var studentsList: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "onCreate")
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
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
        showWelcome = findViewById(R.id.button_main_activity_press)
        welcomeMessage = findViewById(R.id.textview_main_activity_text)
    }

    fun initializeLiseners() {
        showWelcome?.setOnClickListener {
            initiateDisplaySecondActivity()
        }
    }

    fun initiateDisplaySecondActivity() {
        startActivityForResult(
            Intent(this, SecondActivity::class.java).apply {
                putExtra("Name", "Vasya")
            }, REQUEST_CODE_RESULT
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_RESULT -> {
                Toast.makeText(
                    this,
                    data?.getStringExtra(KEY_PERSONS_NAME),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    companion object {
        const val REQUEST_CODE_RESULT = 1
        const val KEY_PERSONS_NAME = "KEY_PERSONS_NAME"
    }
}