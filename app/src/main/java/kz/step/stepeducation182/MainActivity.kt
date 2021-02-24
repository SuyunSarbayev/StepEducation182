package kz.step.stepeducation182

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var showWelcome: Button? = null
    var welcomeMessage: TextView? = null

    val peopleCount = 0
    var studentsList: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    fun initializeViews(){
        showWelcome = findViewById(R.id.button_main_activity_press)
        welcomeMessage = findViewById(R.id.textview_main_activity_text)
    }

    fun initializeLiseners(){
        showWelcome?.setOnClickListener {
            welcomeMessage?.setText("I am pressed!")
        }
    }

    fun initiateCountPersons(){

    }

    fun initiateRequestPersons(){

    }

    companion object{
        const val KEY_PERSONS_NAME = "KEY_PERSONS_NAME"
    }
}