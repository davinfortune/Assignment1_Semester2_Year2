package org.wit.festivalapp.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.festivalapp.artists.store.ArtistJSONStore
import org.wit.festivalapp.artists.interfaces.ArtistStore

class MainApp : Application(), AnkoLogger {

    lateinit var artistArray : ArtistStore
    var day : Int = 0

    override fun onCreate() {
        super.onCreate()
        artistArray =
            ArtistJSONStore(applicationContext)
        info("App started")
    }
}