package org.wit.festivalapp.artists

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artist_add.*
import kotlinx.android.synthetic.main.activity_artist_add.arenaDropdown
import kotlinx.android.synthetic.main.activity_artist_add.artistNameText
import kotlinx.android.synthetic.main.activity_artist_add.dayDropdown
import kotlinx.android.synthetic.main.activity_artist_add.firstImage
import kotlinx.android.synthetic.main.activity_artist_add.genreDropdown
import kotlinx.android.synthetic.main.activity_artist_add.timeText
import kotlinx.android.synthetic.main.activity_artist_add.uploadButton
import kotlinx.android.synthetic.main.activity_artist_details.*
import kotlinx.android.synthetic.main.activity_artist_update.*
import kotlinx.android.synthetic.main.activity_artist_update.updateButton
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.helpers.readImage
import org.wit.festivalapp.helpers.showImagePicker
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen


class UpdateArtist : AppCompatActivity(), AnkoLogger  {

    val IMAGE_REQUEST = 1

    var app : MainApp? = null

    var Image : String = ""

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView
    lateinit var artistScreen : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_update)

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

        var artistButton: ImageView = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
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


        //Update CODE

        if (intent.hasExtra("update_artist")) {
            var artist : ArtistModel = intent.extras.getParcelable<ArtistModel>("update_artist")

            artistName2.setText(artist.artistName + ".")
            Picasso.with(this).load(artist.artistImage).into(firstImage)
            timeText.setText(artist.artistTime)

            var position : Int = 0
            if(artist.artistArena == "Main Stage") position = 1
            if(artist.artistArena == "Heinken Tent") position = 2
            if(artist.artistArena == "Social Tent") position = 3
            if(artist.artistArena == "Techno Trailer") position = 4
            if(artist.artistArena == "Red Bull Arena") position = 5
            arenaDropdown.setSelection(position)



            if(artist.artistGenre == "Pop") position = 1
            if(artist.artistGenre == "Alternate") position = 2
            if(artist.artistGenre == "Rap") position = 3
            if(artist.artistGenre == "EDM") position = 4
            if(artist.artistGenre == "Techno") position = 5
            genreDropdown.setSelection(position)

            if(artist.artistDay == "Friday") position = 1
            if(artist.artistDay == "Saturday") position = 2
            if(artist.artistDay == "Sunday") position = 3
            dayDropdown.setSelection(position)



            updateButton.setOnClickListener() {
                if(artist.artistArena != arenaDropdown.selectedItem.toString() && arenaDropdown.selectedItem.toString() != "Arena") {
                    artist.artistArena = arenaDropdown.selectedItem.toString()
                }

                if(artist.artistGenre != genreDropdown.selectedItem.toString() && genreDropdown.selectedItem.toString() != "Genre") {
                    artist.artistGenre = genreDropdown.selectedItem.toString()
                }


                if (timeText.text.toString() != artist.artistTime) {
                    artist.artistTime = timeText.text.toString()
                }

                if(artist.artistDay != dayDropdown.selectedItem.toString() && dayDropdown.selectedItem.toString() != "Day") {
                    artist.artistDay = dayDropdown.selectedItem.toString()
                }

                if(Image.isNotEmpty()) {
                    if (artist.artistImage != Image) {
                        artist.artistImage = Image
                    }
                }
                var artistScreen = Intent(applicationContext, ArtistScreen::class.java)
                startActivity(artistScreen.putExtra("updated_artist", artist))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            IMAGE_REQUEST -> {
                if (data != null) {
                    Image = data.getData().toString()
                    firstImage.setImageBitmap(readImage(this, resultCode, data))
                }
            }
        }
    }
}