package org.wit.festivalapp.artists

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_artist_add.*
import kotlinx.android.synthetic.main.activity_artist_screen.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.image.ImageScreen
import org.wit.festivalapp.location.LocationScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

class ArtistScreen : AppCompatActivity(), ArtistListener {

    lateinit var app : MainApp

    lateinit var imageButton : ImageView
    lateinit var timetableButton : ImageView
    lateinit var locationButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_screen)
        app = application as MainApp
        if(app.artistArray.size() == 0) {
            app.artistArray.create(ArtistModel("Jon Bellion", "Red Bull Arena", "Alternate", "6:30"))
            app.artistArray.create(ArtistModel("Ariana Grande", "Main Stage", "Pop", "9:00"))
            app.artistArray.create(ArtistModel("Diplo", "Heiniken Tent", "Pop", "7:00"))
        }
        if(intent.hasExtra("add_artist")){
           var addArtist = intent.extras.getParcelable<ArtistModel>("add_artist")
            app.artistArray.create(ArtistModel(addArtist.artistName,addArtist.artistArena,addArtist.artistGenre,addArtist.artistTime))
        }
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
            val locationIntent : Intent = Intent(applicationContext, LocationScreen::class.java)
            startActivity(locationIntent)
        }

        /*Image Button*/
        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener{
            finish()
            val imageIntent : Intent = Intent(applicationContext, ImageScreen::class.java)
            startActivity(imageIntent)
        }


        //ARTIST CODE
        addArtistButton.setOnClickListener{
        val artistIntent : Intent = Intent(applicationContext, AddArtist::class.java)
           startActivity(artistIntent)
        }

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ArtistAdapter(app.artistArray.findAll(), this)
    }

    override fun onArtistClick(artist: ArtistModel) {
        startActivityForResult(intentFor<ArtistDetails>(), 0)
    }
}
