package org.wit.festivalapp.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.festivalapp.artists.ArtistJSONStore
import org.wit.festivalapp.artists.ArtistStore

class MainApp : Application(), AnkoLogger {

    lateinit var artistArray : ArtistStore

    override fun onCreate() {
        super.onCreate()
        artistArray = ArtistJSONStore(applicationContext)
        info("App started")
    }
}