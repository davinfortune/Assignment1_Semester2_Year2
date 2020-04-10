package org.wit.festivalapp.artists.interfaces

import org.wit.festivalapp.artists.store.ArtistModel

interface ArtistStore {
    fun findAll(): List<ArtistModel>
    fun create(artist: ArtistModel)
    fun update(artist: ArtistModel)
    fun delete(artist: ArtistModel)
}