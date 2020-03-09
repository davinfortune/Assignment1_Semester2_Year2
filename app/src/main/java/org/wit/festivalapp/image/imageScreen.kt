package org.wit.festivalapp.image

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.artistScreen
import org.wit.festivalapp.location.locationScreen
import org.wit.festivalapp.timetable.timetableScreen

class imageScreen : AppCompatActivity() {

    lateinit var artistButton: ImageView
    lateinit var timetableButton : ImageView
    lateinit var locationButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_screen)

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

        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
            finish()
            val artistIntent : Intent = Intent(applicationContext, artistScreen::class.java)
            startActivity(artistIntent)
        }
    }
}
