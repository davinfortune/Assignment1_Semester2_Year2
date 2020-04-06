package org.wit.festivalapp.timetable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistScreen

lateinit var artistButton: ImageView
lateinit var homeButton : ImageView

class timetableScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_timetable_screen)

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }


        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
            finish()
            val artistIntent : Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistIntent)
        }

    }
}
