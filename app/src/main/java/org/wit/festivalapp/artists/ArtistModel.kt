package org.wit.festivalapp.artists

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ArtistModel (var artistId : Long = 0, var artistName : String = "", var artistArena : String = "",
                        var artistGenre : String = "",var artistTime : String = "", var artistImage : String = "") : Parcelable