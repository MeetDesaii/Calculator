package com.blackpearl.calculator

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import com.blackpearl.calculator.databinding.ActivityMainBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.apply {

            symbolDot.setOnClickListener {
                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv.isNotEmpty()){
                    if((calculateTv[calculateTv.length-1].toString() != ".")) {
                        calculateTextView.append(".")
                    }
                }
            }

            number0.setOnClickListener {
                performVibration()
                calculateTextView.append("0")
            }

            number1.setOnClickListener {
                performVibration()
                calculateTextView.append("1")
            }

            number2.setOnClickListener {
                performVibration()
                calculateTextView.append("2")
            }

            number3.setOnClickListener {
                performVibration()
                calculateTextView.append("3")
            }

            number4.setOnClickListener {
                performVibration()
                calculateTextView.append("4")
            }

            number5.setOnClickListener {
                performVibration()
                calculateTextView.append("5")
            }

            number6.setOnClickListener {
                performVibration()
                calculateTextView.append("6")
            }

            number7.setOnClickListener {
                performVibration()
                calculateTextView.append("7")
            }

            number8.setOnClickListener {
                performVibration()
                calculateTextView.append("8")
            }

            number9.setOnClickListener {
                performVibration()
                calculateTextView.append("9")
            }

            symbolAddition.setOnClickListener {

                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){

                    if((calculateTv[calculateTv.length-1].toString() == "÷") || (calculateTv[calculateTv.length-1].toString() == "×") || (calculateTv[calculateTv.length-1].toString() == "+")|| (calculateTv[calculateTv.length-1].toString() == "-") || (calculateTv[calculateTv.length-1].toString() == ".")){

                        val arr = calculateTv.toCharArray().toTypedArray()

                        arr[calculateTv.length-1] = '+'

                        val newCalculatedTv = arr.joinToString("")

                        calculateTextView.text = newCalculatedTv
                    }
                    else{
                        calculateTextView.append("+")
                    }
                }
            }

            symbolSubtraction.setOnClickListener {

                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){

                    if((calculateTv[calculateTv.length-1].toString() == "÷") || (calculateTv[calculateTv.length-1].toString() == "×") || (calculateTv[calculateTv.length-1].toString() == "+")|| (calculateTv[calculateTv.length-1].toString() == "-") || (calculateTv[calculateTv.length-1].toString() == ".")){

                        val arr = calculateTv.toCharArray().toTypedArray()

                        arr[calculateTv.length-1] = '-'

                        val newCalculatedTv = arr.joinToString("")

                        calculateTextView.text = newCalculatedTv
                    }
                    else{
                        calculateTextView.append("-")
                    }
                }
            }

            symbolMultiplication.setOnClickListener {

                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){

                    if((calculateTv[calculateTv.length-1].toString() == "÷") || (calculateTv[calculateTv.length-1].toString() == "×") || (calculateTv[calculateTv.length-1].toString() == "+")|| (calculateTv[calculateTv.length-1].toString() == "-") || (calculateTv[calculateTv.length-1].toString() == ".")){

                        val arr = calculateTv.toCharArray().toTypedArray()

                        arr[calculateTv.length-1] = '×'

                        val newCalculatedTv = arr.joinToString("")

                        calculateTextView.text = newCalculatedTv
                    }
                    else{
                        calculateTextView.append("×")
                    }
                }
            }

            symbolDivision.setOnClickListener {

                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){

                    if((calculateTv[calculateTv.length-1].toString() == "÷") || (calculateTv[calculateTv.length-1].toString() == "×") || (calculateTv[calculateTv.length-1].toString() == "+")|| (calculateTv[calculateTv.length-1].toString() == "-") || (calculateTv[calculateTv.length-1].toString() == ".")){

                        val arr = calculateTv.toCharArray().toTypedArray()

                        arr[calculateTv.length-1] = '÷'

                        val newCalculatedTv = arr.joinToString("")

                        calculateTextView.text = newCalculatedTv
                    }
                    else{
                        calculateTextView.append("÷")
                    }
                }
            }

            symbolBracketStart.setOnClickListener {
                performVibration()
                calculateTextView.append("(")
            }

            symbolBracketEnd.setOnClickListener {

                performVibration()

                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){

                    if((calculateTv[calculateTv.length-1].toString() == "÷") || (calculateTv[calculateTv.length-1].toString() == "×") || (calculateTv[calculateTv.length-1].toString() == "+")|| (calculateTv[calculateTv.length-1].toString() == "-") || (calculateTv[calculateTv.length-1].toString() == ".")){

                        val arr = calculateTv.toCharArray().toTypedArray()

                        arr[calculateTv.length-1] = ')'

                        val newCalculatedTv = arr.joinToString("")

                        calculateTextView.text = newCalculatedTv
                    }
                    else{
                        calculateTextView.append(")")
                    }
                }
            }

            symbolAC.setOnClickListener {
                performVibration()
                calculateTextView.text = ""
                resultTextView.text = "0"
                errorArea.text = ""
            }

            symbolBackspace.setOnClickListener {
                performVibration()
                val calculateTv = calculateTextView.text.toString()

                if(calculateTv != ""){
                    val length = calculateTv.length
                    val newCalculateTv = calculateTv.substring(0, length-1)
                    calculateTextView.text = newCalculateTv
                }
            }

            symbolEquals.setOnClickListener {
                performVibration()

                val calculateTv = calculateTextView.text.toString()

                val newCalculateTv = calculateTv.replace("×", "*")
                val finalCalculateTv = newCalculateTv.replace("÷", "/")

//                try{
//                    val expression = ExpressionBuilder(newCalculateTv).build()
//                    val result = expression.evaluate()
//                    val longResult = result.toLong()
//
//                    if(result == longResult.toDouble()){
//                        resultTextView.text = result.toString()
//                    }
//                    else{
//                        resultTextView.text = result.toString()
//                    }
//                }
//                catch (exception : IllegalArgumentException){
//                    errorArea.text = "Error : Cannot Divide by 0"
//                }


                // Evaluation using library
                val resultEngine : ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
                try{

                    val result = resultEngine.eval(finalCalculateTv)
                    resultTextView.text = result.toString()
                }
                catch (e : ScriptException){
                    errorArea.text = "Error : Script Error (Invalid Input)"
                }
            }
        }
    }

    private fun performVibration(){

        // Set vibration on click on button...
        val vibration = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= 26) {
            vibration.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibration.vibrate(50)
        }
    }
}