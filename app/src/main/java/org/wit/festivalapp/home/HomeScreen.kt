package org.wit.festivalapp.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistDetails
import org.wit.festivalapp.artists.ArtistModel
import org.wit.festivalapp.artists.ArtistScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen
import java.util.concurrent.ThreadLocalRandom

/**
Created By : Davin Fortune
Student Number : 20085000
Start Date : 09/03/2020

Tutorials Used :
https://www.youtube.com/watch?v=E4QBMxsIA5U
 **/

class HomeScreen : AppCompatActivity(), AnkoLogger {
    //BUTTONS
    lateinit var artistButton: ImageView
    lateinit var timetableButton : ImageView

    //RIGHT ANIMATION
    lateinit var firstImage : ImageView
    lateinit var firstAnimation : Animation
    lateinit var firstText : TextView

    //LEFT ANIMATION
    lateinit var secondImage : ImageView
    lateinit var secondAnimation : Animation
    lateinit var secondText : TextView

    //LOGO
    lateinit var logoImage : ImageView
    lateinit var logoAnim : Animation

    lateinit var app : MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = application as MainApp

        val words = listOf<String>("Music","Life","Nature","United","Love","Equal","One","Ireland")

        if(app.artistArray.findAll().toString() == "[]") {
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Westlife",
                    "Friday",
                    "Heinken Tent",
                    "Pop",
                    "7:30",
                    "https://i.pinimg.com/474x/a7/a1/68/a7a1684537e14e38d47e3d9b401dcf84.jpg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Ariana Grande",
                    "Saturday",
                    "Main Stage",
                    "Pop",
                    "6:30",
                    "https://www.hawtcelebs.com/wp-content/uploads/2016/04/ariana-grande-las-vegas-promos_6.jpg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Jon Bellion",
                    "Friday",
                    "Red Bull Arena",
                    "Alternate",
                    "5:30",
                    "https://i0.wp.com/www.hypefresh.co/wp-content/uploads/2015/05/Jon-Bellion.jpg?fit=800%2C800&ssl=1"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Bazzi",
                    "Saturday",
                    "Social Tent",
                    "Pop",
                    "6:00",
                    "https://is3-ssl.mzstatic.com/image/thumb/Music114/v4/28/e6/80/28e68085-227b-9e44-4d21-ad66b04acbd0/pr_source.png/800x800bb.jpeg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Joyner Lucas",
                    "Saturday",
                    "Heniken Tent",
                    "Rap",
                    "10:00",
                    "https://res-3.cloudinary.com/dostuff-media/image/upload//c_fill,g_faces,f_auto,w_800/v1512617497/event-poster-8824217.jpg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Quinn XCII",
                    "Friday",
                    "Red Bull Arena",
                    "Alternate",
                    "7:00",
                    "https://is5-ssl.mzstatic.com/image/thumb/Features124/v4/e8/4c/88/e84c88b8-8ea2-b777-f08b-f937c1175875/mzl.uirszhca.jpg/800x800bb.jpeg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Fisher",
                    "Sunday",
                    "Techno Trailer",
                    "Techno",
                    "5:00",
                    "https://is2-ssl.mzstatic.com/image/thumb/Music123/v4/4b/be/13/4bbe13aa-415d-52a0-44a7-7064c75cf04d/pr_source.png/800x800bb.jpeg"
                )
            )
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Afrojack",
                    "Sunday",
                    "Main Stage",
                    "EDM",
                    "11:00",
                    "https://daydreamfestival.jp/wp-content/uploads/sites/3/2020/01/web_afro.jpg"
                )
            )
        }

        //ANIMATION
           //LOGO
        logoImage = findViewById(R.id.homeButton)
        logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_animation)
        logoImage.setAnimation(logoAnim)

          //TOP IMAGE AND TEXT
        firstText = findViewById(R.id.musicText)
        firstImage = findViewById(R.id.firstImage)
        firstAnimation = AnimationUtils.loadAnimation(this,R.anim.first_image_animation)
        firstImage.setAnimation(firstAnimation)
        firstAnimation = AnimationUtils.loadAnimation(this,R.anim.first_text_animation)
        firstText.setAnimation(firstAnimation)


          //BOTTOM IMAGE AND TEXT
        secondText = findViewById(R.id.lifeText)
        secondImage = findViewById(R.id.secondImage)
        secondAnimation = AnimationUtils.loadAnimation(this,R.anim.second_image_animation)
        secondImage.setAnimation(secondAnimation)
        secondAnimation = AnimationUtils.loadAnimation(this,R.anim.second_text_animation)
        secondText.setAnimation(secondAnimation)


        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }


        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
           val artistIntent : Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistIntent)
        }

        var firstNumber : Int = randomNumber(app.artistArray.findAll().size)
        var firstArtistTemp : ArtistModel = app.artistArray.findAll()[firstNumber]
        Picasso.with(this).load(firstArtistTemp.artistImage).into(firstImage)
        var secondNumber : Int = randomNumber(app.artistArray.findAll().size)
        while(secondNumber == firstNumber){
            secondNumber = randomNumber(app.artistArray.findAll().size)
        }
        var secondArtistTemp : ArtistModel = app.artistArray.findAll()[secondNumber]
        Picasso.with(this).load(secondArtistTemp.artistImage).into(secondImage)

        // BUTTON
        firstImage.setOnClickListener{
            onArtistClick(firstArtistTemp)
        }

        secondImage.setOnClickListener{
            onArtistClick(secondArtistTemp)
        }

        firstNumber = randomNumber(words.size)
        musicText.setText("We are " + words[firstNumber] + ".")
        secondNumber = randomNumber(words.size)
        while(secondNumber == firstNumber){
            secondNumber = randomNumber(words.size)
        }
        lifeText.setText("We are " + words[secondNumber] + ".")
    }


    fun onArtistClick(artist: ArtistModel) {
        var detailsScreen : Intent = Intent(applicationContext, ArtistDetails::class.java)
        startActivity(detailsScreen.putExtra("home_artist", artist))
    }


    /** TAKEN FROM : https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin **/
    fun randomNumber(range : Int): Int {
       var rnumber : Int = (0..(range-1)).random()
        return rnumber
    }


}