package com.example.myquizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class Quize : AppCompatActivity() {
    private val questions = arrayOf(
        "1. What is the orange part of an egg called?",
        "2. How many legs do insects have?",
        "3. What is a baby kangaroo called?",
        "4. What is the closest planet to the Sun?",
        "5. In which country can you find the Eiffel Tower",
        "6. How many days are there in a year?",
        "7. How many players are in a soccer team?",
        "8. Where do polar bears live?",
        "9. Which is faster, light or sound?",
        "10. How many letters are in the English alphabet?",
        "11. What is the name of a shape with 5 sides?",
        "12. How many Continents are there?",
        "13. What is the name of the tallest mountain on earth?",
        "14. The planet Mars is also known as what? The ( ) planet.",
        "15. How many months have 31 days?",
        "16. How many colors of the rainbow are there?",
        "17. My mother’s mother is my…what?",
        "18. Which animal lays the largest eggs?",
        "19. How many zeros are in ten thousand?",
        "20.In which country would you find the Sydney Opera House?"
    )

    private val choices = arrayOf(
        arrayOf("Yolk", "Gel", "York", "Woke"),
        arrayOf("Six", "Eight", "Ten", "Two"),
        arrayOf("A Cub", "A pup", "A Joey", "A Kitten"),
        arrayOf("Mercury", "Earth", "Venus", "Mars"),
        arrayOf("USA", "France", "Spain", "Italy"),
        arrayOf("356", "536", "365", "337"),
        arrayOf("Eleven", "Fifteen", "Seven", "Eight"),
        arrayOf("The South Pole", "The Arctic", "Australia", "India"),
        arrayOf("Light", "Sound", "Aeroplane", "Fan"),
        arrayOf("24", "25", "26", "27"),
        arrayOf("Octagon", "Pentagon", "Dodecahedron", "Cube"),
        arrayOf("Seven", "Five", "Six", "Nine"),
        arrayOf("Fuji", "Kilimanjaro", "Mount Everest", "Himalaya"),
        arrayOf("The Red Planet", "The Windy Planet", "The cold Planet", "The Large Planet"),
        arrayOf("Four", "One", "Seven", "Five"),
        arrayOf("Seven", "Five", "Six", "Three"),
        arrayOf("Sister", "Aunt", "Grandmother", "Grandfather"),
        arrayOf("Chicken", "Ostrich", "Turkey", "China"),
        arrayOf("Three", "Four", "Five", "two"),
        arrayOf("Australia", "Canada", "USA", "India")
    )

    private val answer = arrayOf(
        "Yolk",
        "Six",
        "A Joey",
        "Mercury",
        "France",
        "365",
        "Eleven",
        "The Arctic",
        "Light",
        "26",
        "Pentagon",
        "Seven",
        "Mount Everest",
        "The Red Planet",
        "Seven",
        "Seven",
        "Grandmother",
        "Ostrich",
        "Four",
        "Australia"
    )

    private lateinit var t: TextView
    private lateinit var que: TextView
    private lateinit var rg: RadioGroup
    private lateinit var sub: Button
    private lateinit var a: RadioButton
    private lateinit var b: RadioButton
    private lateinit var c: RadioButton
    private lateinit var d: RadioButton
    private var score = 0
    private var id = -1
    private var wcount = 0
    private lateinit var sAnswer: String
    private var totalQuestion = questions.size
    private var currentQuestion = 0
    private var current = 1
    private lateinit var selectedAnswer: RadioButton

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quize)
        que = findViewById(R.id.text_view_question)
        rg = findViewById(R.id.radio_group)
        a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)
        d = findViewById(R.id.d)
        sub = findViewById(R.id.button_confirm_next)
        t = findViewById(R.id.text_view_sco)
        t.text = "Total Question :$currentQuestion/$totalQuestion"
        loadNewQuestion()

        sub.setOnClickListener { view ->

            id = rg.checkedRadioButtonId
            if (currentQuestion < questions.size) {
                if (id < 0) {
                    Toast.makeText(this@Quize , "select one option", Toast.LENGTH_SHORT).show()
                } else {
                    selectedAnswer = findViewById(id)
                    sAnswer = selectedAnswer.text.toString()
                    if (sAnswer == answer[currentQuestion]) {
                        score++
                        //s.text = "Score: $score"
                        rg.clearCheck()
                        currentQuestion++
                    } else {
                        wcount++
                        currentQuestion++
                        rg.clearCheck()
                        //w.text = "Wrong: $wcount"
                    }
                    if (currentQuestion < questions.size) {
                        loadNewQuestion()
                    }
                    else {
                        //Toast.makeText(this@Quize , " NO Question are available", Toast.LENGTH_SHORT).show()
                        if(currentQuestion==questions.size){
                            if(score>18){
                                val intent=Intent(this,great::class.java)

                                intent.putExtra("Scores", score)
                                intent.putExtra("Wrong", wcount)
                                startActivity(intent)
                            }else{
                                val intent=Intent(this,oop::class.java)
                                intent.putExtra("Scores", score)
                                intent.putExtra("Wrong", wcount)
                                startActivity(intent)
                                startActivity(intent)
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(this@Quize , " NO Question are available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadNewQuestion() {
        que.text = questions[currentQuestion]
        a.text = choices[currentQuestion][0]
        b.text = choices[currentQuestion][1]
        c.text = choices[currentQuestion][2]
        d.text = choices[currentQuestion][3]
        t.text = "Total Question :$current/$totalQuestion"
        current++
    }
}
