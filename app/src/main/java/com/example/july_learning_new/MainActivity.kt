package com.example.july_learning_new

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var example: TextView? = null
    private var true_costs: TextView? = null
    private var false_costs: TextView? = null
    private var main_btn: Button? = null
    private var user_answer: EditText? = null
    private var true_answer:String = ""
    private var true_cos = 0
    private var false_cos = 0

    private var one = 0
    private var two = 0
    private var three = 0
    private var znak1 = ""
    private var znak2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn = findViewById(R.id.main_btn)
        example = findViewById(R.id.example_info)
        true_costs = findViewById(R.id.true_coast)
        false_costs = findViewById(R.id.false_coast)
        user_answer = findViewById(R.id.user_field)

        run_generate()
        main_btn?.setOnClickListener {
            if (user_answer?.text?.toString()?.trim()?.equals("")!!) {
                Toast.makeText(this, "Введите число", Toast.LENGTH_LONG).show()
            }
            else {
                val answer: String = user_answer?.text.toString()
                trueOrFalse(answer)

            }
        }

    }
    @SuppressLint("SetTextI18n")
    private fun run_generate(){
        change_primer()

        example?.text = "$one$znak1$two$znak2$three="

    }


    private fun trueOrFalse(value: String){
                if(value == true_answer){
                    true_cos++
                    true_costs?.setText(true_cos.toString())
        }
        else{
            false_cos++
            false_costs?.setText(false_cos.toString())

        }
        run_generate()
    }

    private fun change_primer() {
        var array = emptyArray<Int>()
        while(true){

            val random = Random()
            var chislo1: Int = random.nextInt(100)
            var chislo2: Int = random.nextInt(100)
            var chislo3: Int = random.nextInt(100)
            var variant: Int = random.nextInt(3)
            var otvet: Int = 0
            if(variant ==0){otvet = chislo1+chislo2+chislo3; znak1 = "+"; znak2 = "+"}
            if(variant ==1){otvet = chislo1+chislo2-chislo3; znak1 = "+"; znak2 = "-"}
            if(variant ==2){otvet = chislo1-chislo2+chislo3; znak1 = "-"; znak2 = "+"}
            if(variant ==3){otvet = chislo1-chislo2-chislo3; znak1 = "-"; znak2 = "-"}
            if(otvet >0){
                true_answer = otvet.toString()
                one = chislo1
                two = chislo2
                three = chislo3
                break
            }

        }

        }
}