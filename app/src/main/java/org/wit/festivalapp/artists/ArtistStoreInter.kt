package org.wit.festivalapp.artists

interface ArtistStoreInter {
        fun findAll(): List<ArtistModel>
        fun create(artist: ArtistModel)
}