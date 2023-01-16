package com.example.july_learning_new

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private var layout: RelativeLayout? = null
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

   private var two_btn: Button? = null
    val LOG_TAG = "myLogs"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.general_layout)
        main_btn = findViewById(R.id.main_btn)
        example = findViewById(R.id.example_info)
        true_costs = findViewById(R.id.true_coast)
        false_costs = findViewById(R.id.false_coast)
        user_answer = findViewById(R.id.user_field)
        two_btn = findViewById(R.id.button2)
        run_generate()
        two_btn?.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }


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
                    blinkgGreen()
                    true_cos++
                    true_costs?.setText(true_cos.toString())
                    user_answer?.setText("")
        }
        else{
            blinkgRed()
            false_cos++
            false_costs?.setText(false_cos.toString())
            user_answer?.setText("")
        }
        run_generate()
    }

    private fun change_primer() {

        while(true){

            val random = Random()
            var chislo1: Int = (1..100).random()//random.nextInt(100)
            var chislo2: Int = (1..100).random()
            var chislo3: Int = (1..100).random()
            var variant: Int = random.nextInt(4)
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
    fun blinkgRed() {
        Thread {
            layout?.setBackgroundColor(Color.RED)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.RED)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.RED)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)

        }.start()
    }

    fun blinkgGreen() {
        Thread {
            layout?.setBackgroundColor(Color.GREEN)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GREEN)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GREEN)
            Thread.sleep(100)
            layout?.setBackgroundColor(Color.GRAY)

        }.start()
    }
}


