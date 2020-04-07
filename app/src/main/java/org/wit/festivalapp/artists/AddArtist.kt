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
import org.wit.festivalapp.helpers.readImage
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.helpers.showImagePicker

import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

class AddArtist : AppCompatActivity(), AnkoLogger {

    var artist = ArtistModel()

    val IMAGE_REQUEST = 1

    var app : MainApp? = null

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_add)

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
            val moveIntent: Intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(moveIntent)
        }

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            finish()
            finish()
            val timetableIntent: Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }


        uploadButton.setOnClickListener() {
            showImagePicker(this, IMAGE_REQUEST)
        }


        //ADD CODE
        addButton.setOnClickListener() {
            artist.artistName = artistNameText.text.toString()

            if (artist.artistName.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Name")
            }

            artist.artistArena = arenaText.text.toString()
            if (artist.artistArena.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Arena")
            }

            artist.artistGenre = genreText.text.toString()
            if (artist.artistGenre.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Genre")
            }

            artist.artistTime = timeText.text.toString()
            if (artist.artistTime.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Time")
            }



            if (artist.artistImage.isNotEmpty()) {
                val artistScreen: Intent = Intent(applicationContext, ArtistScreen::class.java)
                startActivity(artistScreen.putExtra("add_artist", artist))
            } else {
                toast("Please Upload an Image")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            IMAGE_REQUEST -> {
                if (data != null) {
                    artist.artistImage = data.getData().toString()
                    firstImage.setImageBitmap(readImage(this, resultCode, data))
                }
            }
        }
    }
}