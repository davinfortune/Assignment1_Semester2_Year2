package org.wit.festivalapp.timetable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.artistScreen
import org.wit.festivalapp.image.imageScreen
import org.wit.festivalapp.location.locationScreen


lateinit var artistButton: ImageView
lateinit var imageButton : ImageView
lateinit var locationButton : ImageView
lateinit var homeButton : ImageView

class timetableScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_screen)

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }

        /*Location Button*/
        locationButton = findViewById(R.id.locationButton)
        locationButton.setOnClickListener {
            finish()
            val locationIntent : Intent = Intent(applicationContext, locationScreen::class.java)
            startActivity(locationIntent)
        }

        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
            finish()
            val artistIntent : Intent = Intent(applicationContext, artistScreen::class.java)
            startActivity(artistIntent)
        }

        /*Image Button*/
        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener{
            finish()
            val imageIntent : Intent = Intent(applicationContext, imageScreen::class.java)
            startActivity(imageIntent)
        }
    }
}
