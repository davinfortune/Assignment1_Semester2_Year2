package org.wit.festivalapp.timetable.interfaces

import org.wit.festivalapp.artists.store.ArtistModel

interface TimeListener {
    fun onTimeClick(artist: ArtistModel)
}