package com.rcd.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    var startButton : Button? =null
    var dice : ImageView? = null
    var comDice : ImageView? = null
    var playerScoreNumber: Int = 0
    var computerScoreNumber: Int = 0
    var displayPlayerScore: TextView? = null
    var displayComputerScore: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        startButton = findViewById(R.id.roll_button)
        dice = findViewById(R.id.dice_image)
        comDice = findViewById(R.id.diceComputer)
        displayPlayerScore = findViewById(R.id.player_score)
        comDice = findViewById(R.id.diceComputer)
        displayComputerScore = findViewById(R.id.computer_score)

        startButton?.setOnClickListener {
            val randomPlayerNumber = (1..6).random()
            dice?.setImageResource(getDiceImage(randomPlayerNumber))
            val randomComputerNumber = (1..6).random()
            comDice?.setImageResource(getDiceImage(randomComputerNumber))
            playerScoreNumber += randomPlayerNumber
            displayPlayerScore?.text = playerScoreNumber.toString()
            computerScoreNumber += randomComputerNumber
            displayComputerScore?.text = computerScoreNumber.toString()
            if (playerScoreNumber >= 100 || computerScoreNumber >= 100) {
                startButton?.isClickable = false
            }
            increment(playerScoreNumber, computerScoreNumber)
            decrement(playerScoreNumber, computerScoreNumber)


        }
    }

    fun increment(player: Int,computer:Int) {
        val incrementScores = mapOf(
            2 to 18,
            11 to 31,
            12 to 28,
            22 to 40,
            36 to 62,
            41 to 59,
            46 to 55,
            70 to 94,
            77 to 84,
            85 to 97)

        val playerScores = incrementScores[player]
        val comScore= incrementScores[computer]
        if (playerScores != null) {
            playerScoreNumber = playerScores
            displayPlayerScore?.text = playerScoreNumber.toString()


        }
        if (comScore != null) {
            computerScoreNumber = comScore
            displayComputerScore?.text= computerScoreNumber.toString()
        }
    }

    fun decrement(player: Int,computer:Int){
        val decrementScore = mapOf(
            21 to 15,
            23 to 6,
            29 to 15,
            35 to 18,
            47 to 32,
            52 to 38,
            71 to 34,
            82 to 59,
            95 to 78,
            99 to 79
        )

        val playerScores = decrementScore[player]
        val comScore= decrementScore[computer]
        if (playerScores != null) {
            playerScoreNumber = playerScores
            displayPlayerScore?.text = playerScoreNumber.toString()


        }
        if (comScore != null) {
            computerScoreNumber = comScore
            displayComputerScore?.text= computerScoreNumber.toString()
        }
    }

    fun getDiceImage(number: Int): Int {
        return when (number) {
            1 -> R.drawable.a
            2 -> R.drawable.b
            3 -> R.drawable.c
            4 -> R.drawable.d
            5 -> R.drawable.e
            else -> R.drawable.f
        }
    }

}