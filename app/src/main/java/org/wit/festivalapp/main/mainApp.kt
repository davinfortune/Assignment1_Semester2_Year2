package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class mainApp : Application(), AnkoLogger {

    override fun onCreate() {
        super.onCreate()
        info("App started")
    }
}