package com.example.calculator_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View){
        val etShowNumber:TextView = findViewById(R.id.etShowNumber)
        if(isNewOp){
            etShowNumber.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue: String = etShowNumber.text.toString()
        when(buSelect.id){
            R.id.bu0->{
                buClickValue+="0"
            }

            R.id.bu1->{
                buClickValue+="1"
            }

            R.id.bu2->{
                buClickValue+="2"
            }

            R.id.bu3->{
                buClickValue+="3"
            }

            R.id.bu4->{
                buClickValue+="4"
            }

            R.id.bu5->{
                buClickValue+="5"
            }

            R.id.bu6->{
                buClickValue+="6"
            }

            R.id.bu7->{
                buClickValue+="7"
            }

            R.id.bu8->{
                buClickValue+="8"
            }

            R.id.bu9->{
                buClickValue+="9"
            }

            R.id.buDot->{
                buClickValue+="."
            }

            R.id.buplusMinuesr->{
                buClickValue = "-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }

var op = "*"
var oldNumber = ""
var isNewOp = true
    fun buOpEevent(View: View){
        val etShowNumber:TextView = findViewById(R.id.etShowNumber)
        var buSelect = View as Button
        when(buSelect.id) {
            R.id.budiv -> {
                op = "/"
            }

            R.id.buMul -> {
                op = "*"
            }

            R.id.buSub -> {
                op = "-"
            }

            R.id.buSum -> {
                op = "+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        etShowNumber.setText(op)
        isNewOp = true
    }

    fun buEqualEvent(View: View){
        val etShowNumber:TextView = findViewById(R.id.etShowNumber)
        val newNumber = etShowNumber.text.toString()
        var finalNumber:Double? = null
        when(op){
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercent(View: View){
        val etShowNumber:TextView = findViewById(R.id.etShowNumber)
        var number = etShowNumber.text.toString().toDouble()/100
        etShowNumber.setText(number.toString())
        isNewOp = true
    }

    fun buClean(View: View){
        val etShowNumber:TextView = findViewById(R.id.etShowNumber)
        etShowNumber.setText("")
        isNewOp = true
    }
}