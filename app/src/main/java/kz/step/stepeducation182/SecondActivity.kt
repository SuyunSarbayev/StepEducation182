package kz.step.stepeducation182

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    var data: Bundle? = null

    fun initializeArguments() {
        data = intent.extras
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initializeArguments()
        initiateProcessData()
    }

    fun initiateProcessData() {
        val name = data?.getString("Name")
        findViewById<TextView>(R.id.textview_acitivity_second_name)
            .setText(name)

        findViewById<Button>(R.id.button_acitivty_second_send).setOnClickListener {
            setResult(
                1,
                Intent().putExtra(
                    MainActivity.KEY_PERSONS_NAME,
                    "Constant"
                )
            )
            finish()
        }
    }
}