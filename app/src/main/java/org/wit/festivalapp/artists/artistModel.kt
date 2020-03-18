package org.wit.festivalapp.artists

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ArtistModel (var artistName : String = "", var artistImage : String = "", var artistArena : String = "",
                        var artistGenre : String = "",var artistTime : String = "") : Parcelable