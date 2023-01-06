package com.example.july_learning_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var example: TextView? = null
    private var true_costs: TextView? = null
    private var false_costs: TextView? = null
    private var main_btn: Button? = null
    private var user_answer: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn = findViewById(R.id.main_btn)
        example = findViewById(R.id.example_info)
        true_costs = findViewById(R.id.true_coast)
        false_costs = findViewById(R.id.false_coast)
        user_answer = findViewById(R.id.user_field)
        main_btn?.setOnClickListener {
            if (user_answer?.text?.toString()?.trim()?.equals("")!!)
                Toast.makeText(this, "Введите число", Toast.LENGTH_LONG).show()
            else {
                val answer: String = user_answer?.text.toString()
            }
        }

    }
}