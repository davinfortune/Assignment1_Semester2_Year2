package org.wit.festivalapp.timetable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_artist_screen.artistButton
import kotlinx.android.synthetic.main.activity_artist_screen.homeButton
import kotlinx.android.synthetic.main.activity_timetable_screen.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistScreen
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.interfaces.TimeListener
import org.wit.festivalapp.timetable.recycler.TimetableAdapter

lateinit var artistButtont: ImageView
lateinit var homeButtont : ImageView
lateinit var app : MainApp

class timetableScreen : AppCompatActivity(),
    TimeListener, AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_screen)
        app = application as MainApp

        /*Home Button*/
        homeButtont = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }


        /*Artist Button*/
        artistButtont = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
            finish()
            val artistIntent : Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistIntent)
        }


        val layoutManager = LinearLayoutManager(this)
        recyclerViewTimetable.layoutManager = layoutManager
        loadArtists()

        friday.setOnClickListener {
            onFridayClick()
        }

        saturday.setOnClickListener {
            onSaturdayClick()
        }

        sunday.setOnClickListener {
            onSundayClick()
        }


        allartists.setOnClickListener {
            loadArtists()
        }

    }

    fun onFridayClick(){

        var looper : Int = app.artistArray.findAll().size
        var friday : List<ArtistModel> = emptyList()
        for (i in 0 until looper){
            if(app.artistArray.findAll()[i].artistDay == "Friday"){
                friday = friday + app.artistArray.findAll()[i]
            }
        }

        recyclerViewTimetable.adapter =
            TimetableAdapter(friday, this)
        recyclerViewTimetable.adapter?.notifyDataSetChanged()
    }

    fun onSaturdayClick(){
        var looper : Int = app.artistArray.findAll().size
        var saturday : List<ArtistModel> = emptyList()
        for (i in 0 until looper){
            if(app.artistArray.findAll()[i].artistDay == "Saturday"){
                saturday = saturday + app.artistArray.findAll()[i]
            }
        }
        info(saturday)

        recyclerViewTimetable.adapter =
            TimetableAdapter(saturday, this)
        recyclerViewTimetable.adapter?.notifyDataSetChanged()
    }

    fun onSundayClick(){
        var looper : Int = app.artistArray.findAll().size
        var sunday : List<ArtistModel> = emptyList()
        for (i in 0 until looper){
            if(app.artistArray.findAll()[i].artistDay == "Sunday"){
                sunday = sunday + app.artistArray.findAll()[i]
            }
        }
        recyclerViewTimetable.adapter =
            TimetableAdapter(sunday, this)
        recyclerViewTimetable.adapter?.notifyDataSetChanged()
    }

    override fun onTimeClick(artist: ArtistModel) {
        var detailsScreen : Intent = Intent(applicationContext, TimetableDetails::class.java)
        startActivity(detailsScreen.putExtra("timetable_artist", artist))
    }
    private fun loadArtists(){
        showArtists(app.artistArray.findAll())
    }

    fun showArtists (artists : List<ArtistModel>){
        recyclerViewTimetable.adapter =
            TimetableAdapter(artists, this)
        recyclerViewTimetable.adapter?.notifyDataSetChanged()
    }
}
