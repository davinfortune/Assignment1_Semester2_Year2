package org.wit.festivalapp.artists

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artist_details.*
import kotlinx.android.synthetic.main.artist_card.view.*
import org.wit.festivalapp.R
import org.wit.festivalapp.helpers.readImageFromPath
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

//  TODO : Look into Coil and Rounded Image https://www.youtube.com/watch?v=_qzENScKT20

class ArtistDetails : AppCompatActivity() {
    lateinit var app : MainApp

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_details)
        app = application as MainApp

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
            val moveIntent : Intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(moveIntent)
        }

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            finish()
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }

        if(intent.hasExtra("details_artist")){
            var artistIn = intent.extras.getParcelable<ArtistModel>("details_artist")

            var name : TextView = findViewById(R.id.artistName)
            name.text = (artistIn.artistName + ".")

            var arena : TextView = findViewById(R.id.arenaName)
            arena.text = (artistIn.artistArena + ".")

            var genre : TextView = findViewById(R.id.genreName)
            genre.text = (artistIn.artistGenre + ".")

            var time : TextView = findViewById(R.id.time)
            time.text = (artistIn.artistTime + ".")

            firstImage.setImageBitmap(readImageFromPath(this, artistIn.artistImage))

            if(artistIn.artistImage.contains("https://")) {
                Picasso.with(this).load(artistIn.artistImage).into(firstImage)
            }
            else {
                firstImage.setImageBitmap(readImageFromPath(this, artistIn.artistImage))
                
            }
            var deleteArtist : ImageView = findViewById(R.id.deleteArtist)
            deleteArtist.setOnClickListener(){
                app.artistArray.delete(artistIn)
                val artistIntent : Intent = Intent(applicationContext, ArtistScreen::class.java)
                startActivity(artistIntent)
            }
        }
    }
}