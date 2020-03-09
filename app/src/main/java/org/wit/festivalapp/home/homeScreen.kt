package org.wit.festivalapp.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.artistScreen

class homeScreen : AppCompatActivity() {

    lateinit var artistButton: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Artist Button
        artistButton = findViewById(R.id.artistButton)

        artistButton.setOnClickListener {
           val artistIntent : Intent = Intent(applicationContext, artistScreen::class.java)
            startActivity(artistIntent)
        }
    }


}