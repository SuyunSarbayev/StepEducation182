package kz.step.stepeducation182

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var button: Button? = null
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    fun initializeViews(){
        button = findViewById(R.id.button_main_activity_press)
        textView = findViewById(R.id.textview_main_activity_text)
    }

    fun initializeLiseners(){
        button?.setOnClickListener {
            textView?.setText("I am pressed!")
        }
    }
}