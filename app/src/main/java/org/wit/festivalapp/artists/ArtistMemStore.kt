package org.wit.festivalapp.artists


var lastId = 0L

internal fun getId(): Long {
    return lastId++
}
class ArtistMemStore : ArtistStore{
        val artists = ArrayList<ArtistModel>()

        override fun findAll(): List<ArtistModel> {
            return artists
        }

        override fun create(artist: ArtistModel) {
            artist.artistId = getId()
            artists.add(artist)
        }

        override fun update(artist: ArtistModel) {
//            var foundartist: ArtistModel? = artists.find { p -> p.id == artist.id }
//            if (foundartist != null) {
//                foundartist.title = artist.title
//                foundartist.description = artist.description
//                foundartist.image = artist.image
//                foundartist.lat = artist.lat
//                foundartist.lng = artist.lng
//                foundartist.zoom = artist.zoom
//                logAll()
//            }
        }

    override fun delete(artist: ArtistModel) {
        artists.remove(artist)
    }

    }