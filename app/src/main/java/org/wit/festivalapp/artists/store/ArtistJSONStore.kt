package org.wit.festivalapp.artists.store

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.wit.festivalapp.artists.interfaces.ArtistStore
import org.wit.placemark.helpers.exists
import org.wit.placemark.helpers.read
import org.wit.placemark.helpers.write
import java.util.*

val JSON_FILE = "artists.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<ArtistModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class ArtistJSONStore :  ArtistStore, AnkoLogger {
    val context: Context
    var artists = mutableListOf<ArtistModel>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<ArtistModel> {
        return artists
    }

   override fun create(artist: ArtistModel) {
        artist.artistId = generateRandomId()
        artists.add(artist)
        serialize()
    }


    override fun update(artist: ArtistModel) {
        // todo
    }

    override fun delete(artist: ArtistModel) {
        artists.remove(artist)
        serialize()
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(artists,
            listType
        )
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context,
            JSON_FILE
        )
        artists = Gson().fromJson(jsonString,
            listType
        )
    }
}