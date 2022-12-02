package com.example.cardgamekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    // create the variables
    lateinit var playerCard: ImageView
    lateinit var opponentCard: ImageView
    lateinit var playerTV: TextView
    lateinit var opponentTV: TextView
    lateinit var b_draw: Button
    lateinit var random: Random
    var player = 0
    var opponent = 0
    var won = 0
    var cardsArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.hearts3,
        R.drawable.hearts4,
        R.drawable.hearts5,
        R.drawable.hearts6,
        R.drawable.hearts7,
        R.drawable.hearts8,
        R.drawable.hearts9,
        R.drawable.hearts10,
        R.drawable.hearts12,
        R.drawable.hearts13,
        R.drawable.hearts14,
        R.drawable.hearts15



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        random = Random()
        // finds the different elments
        playerCard = findViewById(R.id.imageViewP)
        opponentCard = findViewById(R.id.imageViewO)

        playerTV = findViewById(R.id.textViewP)
        opponentTV = findViewById(R.id.textViewO)

        playerCard.setImageResource(R.drawable.card_back)
        opponentCard.setImageResource(R.drawable.card_back)

        b_draw = findViewById(R.id.buttonD)
        b_draw.setOnClickListener {
            // create cards check which is higher and if the target of ten is reached.
            val cardP = random.nextInt(cardsArray.size)
            val cardO = random.nextInt(cardsArray.size)

            setCardImage(cardP,playerCard)
            setCardImage(cardO,opponentCard)

            if (cardP > cardO) {
               player++
               playerTV.text = "Player: $player"
            }else{
                opponent++
                opponentTV.text = "Opponent: $opponent"
            }

            if (player == 10)
               changeToEnd()
            else if (opponent == 10)
                changeToEnd()

        }
    }
    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }
    // an intent to change activity and to send the score to the last activity
    private fun changeToEnd() {
        val intent =  Intent(this, EndActivity::class.java)
        intent.putExtra("Score", player)
        startActivity(intent)
    }
}