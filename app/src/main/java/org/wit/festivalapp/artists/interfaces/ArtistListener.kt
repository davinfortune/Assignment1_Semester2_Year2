package org.wit.festivalapp.artists.interfaces

import org.wit.festivalapp.artists.store.ArtistModel

interface ArtistListener {
    fun onArtistClick(artist: ArtistModel)
}