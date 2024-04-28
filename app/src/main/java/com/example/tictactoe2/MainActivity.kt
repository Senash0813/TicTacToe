package com.example.tictactoe2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val combinationsList = listOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(2, 4, 6),
        intArrayOf(0, 4, 8)
    )

    private var boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var playerTurn = 1
    private var totalSelectedBoxes = 1

     lateinit var playerOneLayout: LinearLayout
     lateinit var playerTwoLayout: LinearLayout
     lateinit var playerOneName: TextView
     lateinit var playerTwoName: TextView
     lateinit var image1: ImageView
     lateinit var image2: ImageView
     lateinit var image3: ImageView
     lateinit var image4: ImageView
     lateinit var image5: ImageView
     lateinit var image6: ImageView
     lateinit var image7: ImageView
     lateinit var image8: ImageView
     lateinit var image9: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerOneName = findViewById(R.id.playerOneName)
        playerTwoName = findViewById(R.id.playerTwoName)
        playerOneLayout = findViewById(R.id.playerOneLayout)
        playerTwoLayout = findViewById(R.id.playerTwoLayout)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)
        image9 = findViewById(R.id.image9)

        val getPlayerOneName = intent.getStringExtra("playerOne")
        val getPlayerTwoName = intent.getStringExtra("playerTwo")

        playerOneName.text = getPlayerOneName
        playerTwoName.text = getPlayerTwoName

        val clickListener = { v: ImageView, position: Int ->
            if (isBoxSelectable(position)) {
                performAction(v, position)
            }
        }

        image1.setOnClickListener { clickListener(image1, 0) }
        image2.setOnClickListener { clickListener(image2, 1) }
        image3.setOnClickListener { clickListener(image3, 2) }
        image4.setOnClickListener { clickListener(image4, 3) }
        image5.setOnClickListener { clickListener(image5, 4) }
        image6.setOnClickListener { clickListener(image6, 5) }
        image7.setOnClickListener { clickListener(image7, 6) }
        image8.setOnClickListener { clickListener(image8, 7) }
        image9.setOnClickListener { clickListener(image9, 8) }

    }

    private fun performAction(imageView: ImageView, selectedBoxPosition: Int) {
        boxPositions[selectedBoxPosition] = playerTurn

        imageView.setImageResource(if (playerTurn == 1) R.drawable.cross_icon else R.drawable.zero_icon_2)

        if (checkPlayerWin()) {
            val winDialog = WinDialog(this, "${if (playerTurn == 1) playerOneName.text else playerTwoName.text} has won the match", this)
            winDialog.setCancelable(false)
            winDialog.show()
        } else if (totalSelectedBoxes == 9) {
            val winDialog = WinDialog(this, "It is a Draw", this)
            winDialog.setCancelable(false)
            winDialog.show()
        } else {
            changePlayerTurn(if (playerTurn == 1) 2 else 1)
            totalSelectedBoxes++
        }
    }

    private fun changePlayerTurn(currentPlayerTurn: Int) {
        playerTurn = currentPlayerTurn
        playerOneLayout.setBackgroundResource(if (playerTurn == 1) R.drawable.round_back_blue_border else R.drawable.round_back_dark_blue)
        playerTwoLayout.setBackgroundResource(if (playerTurn == 2) R.drawable.round_back_blue_border else R.drawable.round_back_dark_blue)
    }

    private fun checkPlayerWin(): Boolean {
        combinationsList.forEach { combination ->
            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
                return true
            }
        }
        return false
    }

    private fun isBoxSelectable(boxPosition: Int): Boolean {
        return boxPositions[boxPosition] == 0
    }

    fun restartMatch() {
        boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        playerTurn = 1
        totalSelectedBoxes = 1

        listOf(image1, image2, image3, image4, image5, image6, image7, image8, image9).forEach {
            it.setImageResource(R.drawable.blank_2)
        }
    }
}