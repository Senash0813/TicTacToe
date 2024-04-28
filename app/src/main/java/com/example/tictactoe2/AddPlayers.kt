package com.example.tictactoe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddPlayers : AppCompatActivity() {

    lateinit var playerOne : EditText
    lateinit var playerTwo : EditText
    lateinit var startBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)


        playerOne = findViewById(R.id.playerOneName)
        playerTwo = findViewById(R.id.playerTwoName)
        startBtn = findViewById(R.id.startGameBtn)

        startBtn.setOnClickListener {

            val getPlayerOneName = playerOne.text.toString()
            val getPlayerTwoName = playerTwo.text.toString()

            if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                Toast.makeText(this@AddPlayers, "Please Enter Player Names", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@AddPlayers, MainActivity::class.java)
                intent.putExtra("playerOne", getPlayerOneName)
                intent.putExtra("playerTwo", getPlayerTwoName)
                startActivity(intent)
            }
        }

    }
}