package com.example.tictactoe2

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class WinDialog(context: Context, private val message: String, private val score: Long, private val mainActivity: MainActivity) :
    Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_dialog_layout)

        val messageTxt = findViewById<TextView>(R.id.messageTxt)
        val startAgainBtn = findViewById<Button>(R.id.startAgainBtn)
        val scoreTxt = findViewById<TextView>(R.id.scoreTxt)

        messageTxt.text = message
        scoreTxt.text = "Score: $score"

        startAgainBtn.setOnClickListener {
            mainActivity.restartMatch()
            dismiss()
        }
    }
}