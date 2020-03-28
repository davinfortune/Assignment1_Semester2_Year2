package org.wit.festivalapp.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.festivalapp.artists.ArtistStore

class MainApp : Application(), AnkoLogger {

    val artistArray = ArtistStore()

    override fun onCreate() {
        super.onCreate()
        info("App started")
    }
}