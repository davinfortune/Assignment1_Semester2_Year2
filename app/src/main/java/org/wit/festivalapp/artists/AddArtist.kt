package org.wit.festivalapp.artists
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_artist_add.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.image.ImageScreen
import org.wit.festivalapp.location.LocationScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

class AddArtist : AppCompatActivity(), AnkoLogger {

    var artist = ArtistModel()

    var app : MainApp? = null

    lateinit var imageButton : ImageView
    lateinit var timetableButton : ImageView
    lateinit var locationButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_add)

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

        //ADD CODE
        addButton.setOnClickListener(){
            artist.artistName = artistNameText.text.toString()

            if(artist.artistName.isNotEmpty()){

            }
            else{
                toast("Please Enter a Valid Name")
            }

            artist.artistArena = arenaText.text.toString()
            if(artist.artistArena.isNotEmpty()){

            }
            else{
                toast("Please Enter a Valid Arena")
            }

            artist.artistGenre = genreText.text.toString()
            if(artist.artistGenre.isNotEmpty()){

            }
            else{
                toast("Please Enter a Valid Genre")
            }

           artist.artistTime = timeText.text.toString()
            if(artist.artistTime.isNotEmpty()){

            }
            else{
                toast("Please Enter a Valid Time")
            }
            val artistScreen : Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistScreen.putExtra("add_artist", artist))
        }
    }
}