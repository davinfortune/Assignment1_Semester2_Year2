package org.wit.festivalapp.artists

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_artist_screen.*
import org.jetbrains.anko.AnkoLogger
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.interfaces.ArtistListener
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.artists.recycler.ArtistAdapter
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

class ArtistScreen : AppCompatActivity(),
    ArtistListener, AnkoLogger {

    lateinit var app : MainApp

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_screen)
        app = application as MainApp


        if(intent.hasExtra("add_artist")){
           var addArtist = intent.extras.getParcelable<ArtistModel>("add_artist")
           app.artistArray.create(
               ArtistModel(
                   0,
                   addArtist.artistName,
                   addArtist.artistDay,
                   addArtist.artistArena,
                   addArtist.artistGenre,
                   addArtist.artistTime,
                   addArtist.artistImage
               )
           )
        }

        if(intent.hasExtra("updated_artist")){
            var tempArtist = intent.extras.getParcelable<ArtistModel>("updated_artist")
            var looper : Int = app.artistArray.findAll().size
            for (i in 0..(looper-1)){
                if(app.artistArray.findAll()[i].artistId == tempArtist.artistId){
                    app.artistArray.findAll()[i].artistArena = tempArtist.artistArena
                    app.artistArray.findAll()[i].artistGenre = tempArtist.artistGenre
                    app.artistArray.findAll()[i].artistDay = tempArtist.artistDay
                    app.artistArray.findAll()[i].artistTime = tempArtist.artistTime
                    app.artistArray.findAll()[i].artistImage = tempArtist.artistImage
                }
            }
        }

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

        //ARTIST CODE
        addArtistButton.setOnClickListener{
        val artistIntent : Intent = Intent(applicationContext, AddArtist::class.java)
           startActivity(artistIntent)
        }

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadArtists()
    }

    override fun onArtistClick(artist: ArtistModel) {
        var detailsScreen : Intent = Intent(applicationContext, ArtistDetails::class.java)
        startActivity(detailsScreen.putExtra("details_artist", artist))
    }
    private fun loadArtists(){
        showArtists(app.artistArray.findAll())
    }

    fun showArtists (artists : List<ArtistModel>){
        recyclerView.adapter =
            ArtistAdapter(artists, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
