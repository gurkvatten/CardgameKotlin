package com.example.cardgamekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    lateinit var textViewEnd: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        textViewEnd = findViewById(R.id.textView2)
        // get the intent with the score.
        val intent = getIntent()
        val score = intent.getIntExtra("Score",0)
        // sends you to the beginning if you press play again.
        val buttonRP = findViewById<Button>(R.id.buttonRP)
        buttonRP.setOnClickListener {
            val intent = Intent(this, IntroScreen::class.java)
            startActivity(intent)
            // checks and changes the textview depending on who won.
        }
        if (score == 10) {
            textViewEnd.setText("You Won!")
        } else
            textViewEnd.setText("You Lost!")


    }




}