package com.example.myquizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class oop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var w: TextView
        lateinit var s: TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)
        var res=findViewById<ImageView>(R.id.imageView5)
        s = findViewById(R.id.score)
        w = findViewById(R.id.wrong)

        val i = intent

        val score = i.getIntExtra("Scores", 0)
        val wcount = i.getIntExtra("Wrong", 0)

        w.text = "Wrong: $wcount"
        s.text = "Score: $score"


        res.setOnClickListener(View.OnClickListener {
            val intent= Intent(this,Second::class.java)
            startActivity(intent)

        })

    }
}