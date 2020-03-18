package org.wit.festivalapp.artists

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.wit.festivalapp.R
import org.wit.festivalapp.image.imageScreen
import org.wit.festivalapp.location.locationScreen
import org.wit.festivalapp.timetable.timetableScreen

class artistDetails : AppCompatActivity() {

    lateinit var imageButton : ImageView
    lateinit var timetableButton : ImageView
    lateinit var locationButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_details)

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            finish()
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }

        /*Location Button*/
        locationButton = findViewById(R.id.locationButton)
        locationButton.setOnClickListener {
            finish()
            val locationIntent : Intent = Intent(applicationContext, locationScreen::class.java)
            startActivity(locationIntent)
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