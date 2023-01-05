package com.example.july_learning_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var example: TextView? = null
    private var true_costs: TextView? = null
    private var false_costs: TextView? = null

    private var answer: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        example = findViewById(R.id.example_info)
        true_costs = findViewById(R.id.true_coast)
        false_costs = findViewById(R.id.false_coast)

//        example?.setText("This is example")
    }
}