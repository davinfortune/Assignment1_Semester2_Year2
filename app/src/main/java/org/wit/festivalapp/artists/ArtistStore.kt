package org.wit.festivalapp.artists

class ArtistStore : ArtistStoreInter {
    val artistArray = ArrayList<ArtistModel>()

    override fun findAll(): List<ArtistModel> {
        return artistArray
    }

    fun size() : Int {
        return artistArray.size
    }

    override fun create(artist : ArtistModel){
        artistArray.add(artist)
    }
}