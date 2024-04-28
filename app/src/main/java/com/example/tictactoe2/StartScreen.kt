package com.example.tictactoe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class StartScreen : AppCompatActivity() {

    lateinit var launchImage : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        launchImage = findViewById(R.id.launchImage)

        launchImage.setOnClickListener(){
               val intent = Intent(this,AddPlayers::class.java)
               startActivity(intent)
        }

    }
}