package com.example.myquizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Second : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var btn: Button = findViewById<Button>(R.id.button)
        var name: EditText? = findViewById<EditText>(R.id.editTextText)

        btn .setOnClickListener(View.OnClickListener {

            val na: String = name?.getText().toString()


            if (na.isEmpty()) {
                Toast.makeText(this@Second, "Please Enter Your name", Toast.LENGTH_SHORT).show()
            } else{

            val intent = Intent(this, Quize::class.java)
            startActivity(intent)}
        })
    }
}