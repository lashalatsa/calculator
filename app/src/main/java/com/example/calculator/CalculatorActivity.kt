package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private var firstVariable = 0.0
    private var secondVariable = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        delbutton.setOnLongClickListener {
            resultTextView.text = ""
            return@setOnLongClickListener true
        }



        dotbutton.setOnClickListener {
            if(resultTextView.text.isNotEmpty() && ("." !in resultTextView.text.toString()))
                resultTextView.text = resultTextView.text.toString() + "."
        }


    }
    fun delete(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty())
            resultTextView.text = value.substring(0, value.length -1)
    }

    fun degree(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = "^"
            resultTextView.text = ""}
    }

    fun divide(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = ":"
            resultTextView.text = ""} }


    fun multiply(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = "x"
            resultTextView.text = ""}
    }


    fun subscription(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = "-"
            resultTextView.text = ""}
    }


    fun plus(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = "+"
            resultTextView.text = ""}
    }

    fun procent(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty()){
            firstVariable = value.toDouble()
            operation = "%"
            resultTextView.text = ""}
    }


    @SuppressLint("SetTextI18n")
    fun equal(view: View){
        val value = resultTextView.text.toString()
        if(value.isNotEmpty())
            secondVariable = value.toDouble()
        var result:Double = 0.0
        if(value.isNotEmpty()){
            if(operation == ":"  && secondVariable != 0.0){
                result = firstVariable/secondVariable
                resultTextView.text = result.toString()}
            else if(operation == ":" && secondVariable == 0.0){
                resultTextView.text = "error"
                Toast.makeText(this, "Can not divide by 0", Toast.LENGTH_SHORT).show()}
            else if(operation == "x"){
                result = firstVariable*secondVariable
                resultTextView.text = result.toString()}
            else if(operation == "-"){
                result = firstVariable-secondVariable
                resultTextView.text = result.toString()}
            else if(operation == "+"){
                result = firstVariable+secondVariable
                resultTextView.text = result.toString()}
            else if(operation == "%"){
                result = firstVariable*(secondVariable/100)
                resultTextView.text = result.toString()}
            else if(operation == "^"){
                result = pow(firstVariable, secondVariable)
                resultTextView.text = result.toString()}}


    }

    override fun onClick(v: View?) {
        val button = v as Button
        resultTextView.text = "${resultTextView.text}${button.text}"



    }

}