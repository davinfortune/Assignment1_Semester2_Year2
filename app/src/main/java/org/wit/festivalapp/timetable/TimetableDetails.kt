package org.wit.festivalapp.timetable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_timetable_details.*
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistScreen
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp

/** SCROLL VIEW TAKEN FROM = https://stackoverflow.com/questions/3058164/android-scrolling-an-imageview **/

class TimetableDetails : AppCompatActivity() {
    lateinit var app: MainApp

    lateinit var timetableButton: ImageView
    lateinit var homeButton: ImageView
    lateinit var artistIn: ArtistModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_details)
        app = application as MainApp
        var map : ImageView = findViewById(R.id.map)

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
            if(artistIn.artistArena == "Main Stage") Picasso.with(this).load(R.mipmap.mainstage).into(map)
            if(artistIn.artistArena == "Heineken Tent") Picasso.with(this).load(R.mipmap.heinkentent).into(map)
            if(artistIn.artistArena == "Red Bull Arena") Picasso.with(this).load(R.mipmap.redbullarena).into(map)
            if(artistIn.artistArena == "Social Tent") Picasso.with(this).load(R.mipmap.socialtent).into(map)
            if(artistIn.artistArena == "Techno Trailer") Picasso.with(this).load(R.mipmap.technotrailer).into(map)



            artistName3.setText(artistIn.artistName+".")
            artistTime.setText(artistIn.artistTime+".")
            }
        }

    }

