package org.wit.festivalapp.artists

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_artist_add.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.helpers.readImage
import org.wit.festivalapp.helpers.showImagePicker
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen


class AddArtist : AppCompatActivity(), AnkoLogger  {

    var artist = ArtistModel()

    val IMAGE_REQUEST = 1

    var app : MainApp? = null

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView
    lateinit var artistScreen : Intent

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

        var artistButton : ImageView = findViewById(R.id.artistButton)
        artistButton.setOnClickListener{
            artistScreen = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistScreen)
        }



        uploadButton.setOnClickListener() {
            showImagePicker(this, IMAGE_REQUEST)
        }

        /** TAKEN FROM : https://developer.android.com/guide/topics/ui/controls/spinner **/
        var spinner: Spinner = findViewById(R.id.arenaDropdown)
        ArrayAdapter.createFromResource(
            this,
            R.array.arena_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }

        spinner = findViewById(R.id.genreDropdown)
        ArrayAdapter.createFromResource(
            this,
            R.array.genre_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }

        spinner = findViewById(R.id.dayDropdown)
        ArrayAdapter.createFromResource(
            this,
            R.array.day_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }

        //ADD CODE
        addButton.setOnClickListener() {
            artist.artistName = artistNameText.text.toString()

            if (artist.artistName.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Name")
                return@setOnClickListener
            }


            artist.artistArena = arenaDropdown.selectedItem.toString()

            if(artist.artistArena.contains("Arena"))
            {
                toast("Please Enter a Valid Arena")
                return@setOnClickListener
            }
            artist.artistGenre = genreDropdown.selectedItem.toString()
            if (artist.artistGenre.contains("Genre")) {
                toast("Please Enter a Valid Genre")
                return@setOnClickListener
            }

            artist.artistTime = timeText.text.toString()
            if (artist.artistTime.isNotEmpty()) {

            } else {
                toast("Please Enter a Valid Time")
                return@setOnClickListener
            }

            artist.artistDay = dayDropdown.selectedItem.toString()
            if (artist.artistDay.contains("Day")){
                toast("Please Enter a Valid Day")
                return@setOnClickListener
            }


            if (artist.artistImage.isNotEmpty()) {
                artistScreen = Intent(applicationContext, ArtistScreen::class.java)
                startActivity(artistScreen.putExtra("add_artist", artist))
            } else {
                toast("Please Upload an Image")
                return@setOnClickListener
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