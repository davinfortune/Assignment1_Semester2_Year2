package org.wit.festivalapp.timetable.TimetableDetails

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistScreen
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

//  TODO : Look into Coil and Rounded Image https://www.youtube.com/watch?v=_qzENScKT20

class TimetableDetails : AppCompatActivity() {
    lateinit var app: MainApp

    lateinit var timetableButton: ImageView
    lateinit var homeButton: ImageView
    lateinit var artistIn: ArtistModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_details)
        app = application as MainApp


        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
            val moveIntent: Intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(moveIntent)
        }

        var artistButton: ImageView = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
            val artistScreen: Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistScreen)
        }

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            finish()
            val timetableIntent: Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }

        if (intent.hasExtra("timetable_artist")) {
            artistIn = intent.extras.getParcelable<ArtistModel>("timetable_artist")

            }
        }

    }
}
